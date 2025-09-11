package com.bonface.pokedex.ui.homescreen

import android.graphics.Bitmap
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.bonface.consumerapi.data.model.Pokedex
import com.bonface.designsystem.components.card.BasicCard
import com.bonface.designsystem.components.card.CardStyleDefaults
import com.bonface.designsystem.components.image.BasicImage
import com.bonface.designsystem.components.text.BasicText
import com.bonface.designsystem.extensions.PaletteUtils.convertImageUrlToBitmap
import com.bonface.designsystem.extensions.customColors
import com.bonface.designsystem.extensions.derivedBackgroundColor
import com.bonface.designsystem.extensions.dimensions
import com.bonface.designsystem.theme.PokedexTheme
import com.bonface.pokedex.R

@Composable
fun PokemonCard(
    modifier: Modifier = Modifier,
    pokedex: Pokedex,
    navigateToDetails: (Int) -> Unit,
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
    val backgroundColor by derivedBackgroundColor(bitmap)
    BasicCard(
        style = CardStyleDefaults.default().copy(color = backgroundColor),
        clickable = true,
        onClick = { navigateToDetails(pokedex.pokemonId) },
        modifier = modifier
            .padding(MaterialTheme.dimensions.xSmall)
            .fillMaxWidth()
    ) {
        Box(
            modifier = modifier
                .height(dimensionResource(R.dimen.dimen_220))
                .padding(top = MaterialTheme.dimensions.medium)
                .fillMaxSize(),
            Alignment.TopCenter
        ) {
            BasicImage(
                imageUrl = pokedex.imageUrl,
                modifier = Modifier.size(dimensionResource(R.dimen.dimen_140))
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black),
                        startY = 300f
                    )
                )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(dimensionResource(R.dimen.dimen_12)),
                contentAlignment = Alignment.BottomCenter
            ) {
                BasicText(
                    text = pokedex.name.replaceFirstChar { it.titlecase() },
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.customColors.white,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun PokemonCardPreview() {
    PokedexTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.dimensions.medium)
        ) {
            PokemonCard(
                pokedex = Pokedex(
                    name = "Bulbasaur",
                    imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
                    pokemonId = 1
                ),
                navigateToDetails = {}
            )
        }
    }
}