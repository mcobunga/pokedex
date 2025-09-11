package com.bonface.pokedex.ui.detailscreen

import android.graphics.Bitmap
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.palette.graphics.Palette

@Composable
internal fun Bitmap?.bitMapBackgroundBrush(): State<Brush> {
  val defaultBackground = MaterialTheme.colorScheme.background

  return remember(this) {
    derivedStateOf {
      if (this == null) {
        Brush.linearGradient(listOf(defaultBackground, defaultBackground))
      } else {
        val palette = Palette.from(this).generate()
        val dominant = palette.dominantSwatch?.rgb?.let(::Color)
        val light = palette.lightVibrantSwatch?.rgb?.let(::Color)

        when {
          dominant != null && light != null -> {
            Brush.verticalGradient(
              colorStops = arrayOf(0.0f to dominant, 1f to light)
            )
          }
          dominant != null -> {
            Brush.verticalGradient(listOf(dominant, dominant.copy(alpha = 0.9f)))
          }
          else -> {
            Brush.linearGradient(listOf(defaultBackground, defaultBackground))
          }
        }
      }
    }
  }
}
