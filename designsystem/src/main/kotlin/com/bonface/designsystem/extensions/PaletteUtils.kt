package com.bonface.designsystem.extensions

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

/**
 * Utility object for working with image palettes and bitmaps.
 */
object PaletteUtils {

    /**
     * Downloads an image from a given URL and converts it into a [Bitmap].
     *
     * This function uses [Glide] under the hood to load the image asynchronously
     * and wraps the callback-based API into a cancellable coroutine using
     * [suspendCancellableCoroutine].
     *
     * If the image fails to load, the function returns `null`.
     * If the coroutine is cancelled, the Glide request is also cleared to prevent leaks.
     *
     * @param imageUrl the URL of the image to be downloaded.
     * @param context the [Context] used by [Glide] to execute the image request.
     *
     * @return the loaded [Bitmap], or `null` if loading fails.
     *
     * @see Glide
     * @see suspendCancellableCoroutine
     */
    suspend fun convertImageUrlToBitmap(
        imageUrl: String,
        context: Context,
    ): Bitmap? = suspendCancellableCoroutine { continuation ->
        val target = object : CustomTarget<Bitmap>() {
            override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                if (continuation.isActive) continuation.resume(resource)
            }

            override fun onLoadCleared(placeholder: Drawable?) {}

            override fun onLoadFailed(errorDrawable: Drawable?) {
                if (continuation.isActive) continuation.resume(null)
            }
        }

        Glide.with(context)
            .asBitmap()
            .load(imageUrl)
            .into(target)

        continuation.invokeOnCancellation {
            Glide.with(context).clear(target)
        }
    }
}