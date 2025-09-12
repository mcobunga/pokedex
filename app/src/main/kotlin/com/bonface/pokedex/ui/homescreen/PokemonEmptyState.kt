package com.bonface.pokedex.ui.homescreen

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import com.bonface.designsystem.components.empty.EmptyContainer
import com.bonface.designsystem.extensions.boldQueryText
import com.bonface.designsystem.helpers.EMPTY
import com.bonface.pokedex.R

@Composable
fun PokemonEmptyState(
    modifier: Modifier = Modifier,
    searchQuery: String,
    isError: Boolean = false,
    title: String,
    description: String = EMPTY,
    buttonText: String = EMPTY,
    onButtonClick: () -> Unit = {}
) {
    val icon = when {
        searchQuery.isNotEmpty() -> painterResource(com.bonface.designsystem.R.drawable.ic_search_normal)
        isError -> painterResource(com.bonface.designsystem.R.drawable.ic_close)
        else -> painterResource(com.bonface.designsystem.R.drawable.ic_empty_state)
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        EmptyContainer(
            title = if (searchQuery.isEmpty()) title else EMPTY,
            annotatedTitle = if (searchQuery.isNotEmpty()) boldQueryText(searchQuery) else AnnotatedString(EMPTY),
            description = description,
            icon = icon,
            iconTint = Color.Unspecified,
            iconSize = dimensionResource(R.dimen.dimen_70),
            buttonText = buttonText,
            buttonOnClick = onButtonClick
        )
    }
}