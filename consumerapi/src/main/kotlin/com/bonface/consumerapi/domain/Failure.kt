package com.bonface.consumerapi.domain

sealed interface Failure : Error {
    sealed class Network : Failure {
        data object RequestTimeout : Network()
        data object AccessDenied: Network()
        data object TooManyRequests : Network()
        data object NoInternet : Network()
        data object PayloadTooLarge : Network()
        data class ServerError(val message: String? = "Internal server error") : Network()
        data object Serialization : Network()
        data object Unknown : Network()
    }

    sealed class Local : Failure {
        data class DiskFull(val message: String? = null) : Local()
    }
}
