package com.bonface.designsystem.theme.token.avatar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.res.dimensionResource
import com.bonface.designsystem.R

/**
 * Provides default [Avatars] configurations used across the application.
 *
 * The [AvatarDefaults] object centralizes predefined avatar size sets that can be
 * used to maintain visual consistency throughout the UI. These defaults are backed
 * by dimension resources, making them themeable and easy to adjust without changing
 * code.
 */
object AvatarDefaults {

    /**
     * Standard version 1 of [Avatars] sizing.
     *
     * Loads avatar dimensions from resource values defined in `res/values/dimens.xml`.
     * This includes [normal], [small], [medium], [large], and [xLarge] sizes, ensuring
     * consistent avatar usage across different composables.
     *
     * Example use:
     * ```
     * val avatars = AvatarDefaults.V1
     * Image(
     *     painter = painterResource(R.drawable.profile),
     *     contentDescription = null,
     *     modifier = Modifier.size(avatars.medium)
     * )
     * ```
     */
    val V1
        @Composable
        @ReadOnlyComposable
        get() = Avatars(
            normal = dimensionResource(R.dimen.avatar_normal),
            small = dimensionResource(R.dimen.avatar_small),
            medium = dimensionResource(R.dimen.avatar_medium),
            large = dimensionResource(R.dimen.avatar_large),
            xLarge = dimensionResource(R.dimen.avatar_xlarge),
        )
}

