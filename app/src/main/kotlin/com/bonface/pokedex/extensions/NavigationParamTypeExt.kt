package com.bonface.pokedex.extensions

import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavType
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.nio.charset.StandardCharsets


internal class NavigationParamType<T : Any>(private val clazz: Class<T>) : NavType<T?>(isNullableAllowed = false) {

    private val moshi: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    override fun get(bundle: Bundle, key: String): T? = bundle.parcelable(key)

    override fun put(bundle: Bundle, key: String, value: T?) {
        bundle.putParcelable(key, value as? Parcelable)
    }

    override fun parseValue(value: String): T {
        val decoded = Uri.decode(value)
        return moshi.adapter(clazz).fromJson(decoded)
            ?: throw IllegalArgumentException("Failed to parse $decoded to ${clazz.simpleName}")
    }

    companion object {
        fun <T> encodeToString(navParams: T): String {
            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
            return Uri.encode(moshi.adapter(Any::class.java).toJson(navParams), StandardCharsets.UTF_8.toString())
        }
    }
}