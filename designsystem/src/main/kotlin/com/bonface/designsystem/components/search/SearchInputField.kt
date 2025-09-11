package com.bonface.designsystem.components.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.bonface.designsystem.R
import com.bonface.designsystem.components.input.InputTextField
import com.bonface.designsystem.components.text.BasicText
import com.bonface.designsystem.extensions.dimensions
import com.bonface.designsystem.extensions.textFieldOutlineColor
import com.bonface.designsystem.helpers.EMPTY
import com.bonface.designsystem.theme.PokedexTheme

/**
 * A composable search input field with a customizable placeholder, leading search icon, and optional action on done.
 *
 * This component wraps an `InputTextField` and provides:
 * - A search icon as a prefix
 * - A customizable placeholder string
 * - Full-width layout by default
 * - Keyboard "Done" IME action triggering a callback
 *
 * @param modifier Modifier to be applied to the input field. Defaults to [Modifier].
 * @param placeholder Text to be displayed when the input field is empty. Defaults to [EMPTY].
 * @param value The current text entered in the input field.
 * @param iconTint Color tint applied to the search icon. Defaults to [Color.Unspecified].
 * @param onSearchValueChange Callback triggered when the input value changes.
 * @param onDone Callback triggered when the "Done" action is pressed on the keyboard. Defaults to a no-op.
 */
@Composable
fun SearchInputField(
    modifier: Modifier = Modifier,
    placeholder: String = EMPTY,
    value: String,
    iconTint: Color = Color.Unspecified,
    onSearchValueChange: (String) -> Unit,
    onDone: () -> Unit = {},
) {
    InputTextField(
        value = value,
        onValueChange = onSearchValueChange,
        modifier = modifier.fillMaxWidth(),
        placeholder = {
            BasicText(
                text = placeholder,
                color = MaterialTheme.colorScheme.onSurface,
            )
        },
        prefix = {
            Box(modifier = Modifier.padding(end = MaterialTheme.dimensions.small)) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search_normal),
                    tint = iconTint,
                    contentDescription = null,
                    modifier = Modifier
                        .size(MaterialTheme.dimensions.medium),
                )
            }
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = { onDone() }),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = textFieldOutlineColor(false, isFocused = true),
        ),
    )
}

@Composable
@PreviewLightDark
fun SearchInputFieldPreview() {
    val searchQuery by remember { mutableStateOf(EMPTY) }
    PokedexTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background)
                .padding(MaterialTheme.dimensions.medium),
        ) {
            SearchInputField(
                placeholder = "Search pokemon",
                value = searchQuery,
                onSearchValueChange = {},
                modifier = Modifier.padding(MaterialTheme.dimensions.medium),
            )
        }
    }
}
