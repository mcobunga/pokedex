package com.bonface.pokedex.extensions

import androidx.navigation.NamedNavArgument

/**
 * Appends argument placeholders to a base navigation route string.
 *
 * This function inspects the provided [navArguments] and constructs a route pattern that
 * includes placeholders for both mandatory and optional arguments:
 *
 * - **Mandatory arguments** (no default value) are appended as path segments, e.g.:
 *   ```
 *   "details".appendArguments(listOf(navArgument("id") { ... }))
 *   // -> "details/{id}"
 *   ```
 *
 * - **Optional arguments** (with a default value) are appended as query parameters, e.g.:
 *   ```
 *   "search".appendArguments(listOf(navArgument("filter") { defaultValue = "all" }))
 *   // -> "search?filter={filter}"
 *   ```
 *
 * @receiver The base route string.
 * @param navArguments The list of navigation arguments that define mandatory and optional params.
 * @return A new route string with the proper placeholders appended.
 */
internal fun String.appendArguments(navArguments: List<NamedNavArgument>): String {
    val mandatoryArguments = navArguments.filter { it.argument.defaultValue == null }
        .takeIf { it.isNotEmpty() }
        ?.joinToString(separator = "/", prefix = "/") { "{${it.name}}" }
        .orEmpty()
    val optionalArguments = navArguments.filter { it.argument.defaultValue != null }
        .takeIf { it.isNotEmpty() }
        ?.joinToString(separator = "&", prefix = "?") { "${it.name}={${it.name}}" }
        .orEmpty()
    return "$this$mandatoryArguments$optionalArguments"
}

/**
 * Replaces a single argument placeholder in a route string with the provided parameter value.
 *
 * This function is used to generate a concrete navigation route by substituting the first
 * argument placeholder (`{argName}`) in the [name] string with the given [navParam].
 * If the associated [NavType] is a [NavigationParamType], the parameter will be encoded
 * using Moshi serialization by default. Otherwise, [toString] is used.
 *
 * Example:
 * ```
 * val args = listOf(navArgument("id") { type = NavType.IntType })
 * replaceRoute("details/{id}", 42, args)
 * // -> "details/42"
 * ```
 *
 * @param name The route pattern containing an argument placeholder.
 * @param navParam The parameter value to substitute into the route.
 * @param navArguments The navigation argument definitions associated with the route.
 * @param encode Whether to encode the parameter value if a [NavigationParamType] is used.
 *               Defaults to `true`. Disable when using primitives with built-in [NavType].
 * @return A concrete navigation route string with the placeholder replaced.
 */
internal fun <T> replaceRoute(
    name: String,
    navParam: T,
    navArguments: List<NamedNavArgument>,
    encode: Boolean = true
): String {
    val navType = navArguments.first().argument.type
    val value = if (encode && navType is NavigationParamType<*>) {
        NavigationParamType.encodeToString(navParam)
    } else {
        navParam.toString()
    }
    return name.replace("{${navArguments.first().name}}", value)
}