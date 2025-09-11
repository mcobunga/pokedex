package com.bonface.pokedex.ui.detailscreen

import android.graphics.Bitmap
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bonface.consumerapi.data.model.PokedexDetails
import com.bonface.designsystem.components.image.BasicImage
import com.bonface.designsystem.components.text.BasicText
import com.bonface.designsystem.extensions.PaletteUtils.convertImageUrlToBitmap
import com.bonface.designsystem.extensions.capitalizeFirst
import com.bonface.designsystem.extensions.customColors
import com.bonface.designsystem.extensions.dimensions
import com.bonface.pokedex.R

@Composable
fun PokemonDetailsHeader(
    pokedex: PokedexDetails,
    onBack: () -> Unit,
) {
    var bitmap by remember { mutableStateOf<Bitmap?>(null) }
    val context = LocalContext.current

    LaunchedEffect(key1 = true) {
        val urlToBitmap = try {
            convertImageUrlToBitmap(
                imageUrl = pokedex.imageUrl,
                context = context
            )
        } catch (e: Exception) {
            null
        }
        bitmap = urlToBitmap
    }

    val shape = RoundedCornerShape(
        topStart = MaterialTheme.dimensions.none,
        topEnd = MaterialTheme.dimensions.none,
        bottomStart = MaterialTheme.dimensions.xLarge,
        bottomEnd = MaterialTheme.dimensions.xLarge,
    )

    val backgroundBrush by bitmap.bitMapBackgroundBrush()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(290.dp)
            .shadow(elevation = MaterialTheme.dimensions.xSmall, shape = shape)
            .background(brush = backgroundBrush, shape = shape),
    ) {
        Row(
            modifier = Modifier
                .padding(dimensionResource(R.dimen.dimen_12))
                .statusBarsPadding(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                modifier = Modifier
                    .padding(end = MaterialTheme.dimensions.small)
                    .clickable { onBack() },
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                tint = Color.White,
                contentDescription = null,
            )

            BasicText(
                modifier = Modifier.padding(horizontal = MaterialTheme.dimensions.small),
                text = pokedex.name.replaceFirstChar { it.titlecase() },
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.customColors.white,
                fontWeight = FontWeight.Bold,
            )
        }

        BasicText(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(MaterialTheme.dimensions.small)
                .statusBarsPadding(),
            style = MaterialTheme.typography.bodyLarge,
            text = pokedex.pokemonId,
            color = MaterialTheme.customColors.white,
            fontWeight = FontWeight.Bold,
        )

        BasicImage(
            imageUrl = pokedex.imageUrl,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = MaterialTheme.dimensions.large)
                .size(200.dp)

        )
    }

    BasicText(
        modifier = Modifier
            .padding(top = MaterialTheme.dimensions.large)
            .fillMaxWidth(),
        text = pokedex.name.capitalizeFirst(),
        style = MaterialTheme.typography.headlineSmall,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
    )
}