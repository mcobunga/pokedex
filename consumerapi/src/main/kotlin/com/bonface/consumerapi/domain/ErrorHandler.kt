package com.bonface.consumerapi.domain

import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import javax.net.ssl.SSLHandshakeException

class ErrorHandler {

    fun handleException(exception: Exception): Failure.Network {
        return when (exception) {
            is UnknownHostException, is ConnectException -> Failure.Network.NoInternet
            is SocketTimeoutException -> Failure.Network.RequestTimeout
            is SSLHandshakeException -> Failure.Network.Unknown
            is HttpException -> handleHttpException(exception)
            is IOException -> Failure.Network.RequestTimeout
            else -> Failure.Network.Unknown
        }
    }

    private fun handleHttpException(exception: HttpException): Failure.Network {
        return when(exception.code()) {
            403 -> Failure.Network.AccessDenied
            408 -> Failure.Network.RequestTimeout
            413 -> Failure.Network.PayloadTooLarge
            500, 503 -> Failure.Network.ServerError(getServerSideErrorMessage(exception.response()))
            else -> Failure.Network.Unknown
        }
    }

    fun getServerSideErrorMessage(response: Response<*>?): String {
        val jsonString = response?.errorBody()?.string()
        return try {
            jsonString?.let { JSONObject(it).optString("message", response.message()) } ?: response?.message() ?: "Unknown server error"
        } catch (jsonException: JSONException) {
            jsonException.printStackTrace()
            response?.message() ?: "Unknown server error"
        }
    }
}