package com.bonface.consumerapi.converters

import com.bonface.consumerapi.data.model.Pokedex
import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

/**
 * Provides custom JSON converters for Moshi serialization and deserialization
 * of [Pokedex] objects. These converters are useful when integrating with APIs
 * or persisting data in a Room database that requires storing objects as JSON strings.
 *
 * Enhancements:
 * - Uses a cached Moshi adapter instead of rebuilding on every call.
 * - Correctly serializes and deserializes a single [Pokedex] instead of using
 *   a parameterized `List` type unnecessarily.
 * - Handles null inputs gracefully.
 */
class Converters {

    private val moshi: Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val pokedexAdapter: JsonAdapter<Pokedex> = moshi.adapter(Pokedex::class.java)

    /**
     * Converts a [Pokedex] object to its JSON string representation.
     *
     * @param value the [Pokedex] object to serialize.
     * @return a JSON string representation of the [Pokedex].
     */
    @ToJson
    fun toJsonPokedexString(value: Pokedex): String = pokedexAdapter.toJson(value)

    /**
     * Converts a JSON string into a [Pokedex] object.
     *
     * @param value the JSON string to deserialize.
     * @return the [Pokedex] object, or `null` if parsing fails or [value] is null.
     */
    @FromJson
    fun fromJsonToPokedex(value: String?): Pokedex? {
        if (value.isNullOrBlank()) return null
        return runCatching { pokedexAdapter.fromJson(value) }.getOrNull()
    }
}