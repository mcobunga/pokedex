package com.bonface.designsystem.components.input

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.bonface.designsystem.helpers.ONE
import com.bonface.designsystem.components.text.BasicText
import com.bonface.designsystem.extensions.customColors
import com.bonface.designsystem.helpers.EMPTY
import com.bonface.designsystem.theme.PokedexTheme

/**
 * A customizable input field built on top of [OutlinedTextField], styled to
 * match the application design system.
 *
 * This component supports labels, placeholders, icons, supporting text,
 * prefixes, suffixes, error states, and focus change handling while
 * providing sensible defaults for colors, typography, and shape.
 *
 * Commonly used for forms, authentication flows, or any screen requiring
 * text input with consistent styling.
 *
 * @param modifier the [Modifier] to be applied to the input field container.
 * Defaults to [Modifier].
 * @param value the current text value to be displayed inside the input field.
 * @param enabled controls whether the input field is enabled for user interaction.
 * @param hasError indicates whether the field is in an error state, affecting styling.
 * @param keyboardOptions software keyboard configuration such as input type,
 * capitalization, and IME action.
 * @param keyboardActions callbacks to handle IME actions such as "Done" or "Next".
 * @param visualTransformation transforms the displayed text (e.g., password masking).
 * @param onValueChange callback invoked whenever the input text changes.
 * @param onFocusChanged callback invoked whenever the focus state of the input changes.
 * @param label optional label composable displayed above the text field when focused or populated.
 * @param placeholder optional placeholder composable displayed when the field is empty.
 * @param trailingIcon optional composable displayed at the trailing edge of the text field.
 * @param leadingIcon optional composable displayed at the leading edge of the text field.
 * @param supportingText optional composable displayed below the text field, typically for hints or errors.
 * @param prefix optional composable displayed before the input text inside the field.
 * @param suffix optional composable displayed after the input text inside the field.
 * @param colors the color configuration for text, borders, and indicators.
 * Defaults to design-system aligned colors via [OutlinedTextFieldDefaults.colors].
 * @param minLines the minimum number of lines for the input field.
 * Defaults to a single line. If greater than one, `singleLine` will be set to false.
 *
 * @sample com.bonface.designsystem.components.input.InputTextFieldPreview
 *
 * @see OutlinedTextField
 * @see TextFieldColors
 */
@Composable
fun InputTextField(
    modifier: Modifier = Modifier,
    value: String = EMPTY,
    enabled: Boolean = true,
    hasError: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    keyboardActions: KeyboardActions = KeyboardActions(),
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: (value: String) -> Unit = {},
    onFocusChanged: (FocusState) -> Unit = {},
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    supportingText: @Composable (() -> Unit)? = null,
    prefix: @Composable (() -> Unit)? = null,
    suffix: @Composable (() -> Unit)? = null,
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors(
        unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
        unfocusedLabelColor = MaterialTheme.colorScheme.onSecondary,
        unfocusedBorderColor = MaterialTheme.colorScheme.outline,
        focusedTextColor = MaterialTheme.colorScheme.onSurface,
        focusedBorderColor = MaterialTheme.colorScheme.outline,
        cursorColor = MaterialTheme.colorScheme.primary,
        errorBorderColor = MaterialTheme.colorScheme.error,
        errorTextColor = MaterialTheme.colorScheme.onBackground,
        disabledBorderColor = MaterialTheme.colorScheme.outline,
        disabledContainerColor = MaterialTheme.customColors.disabled,
        disabledTextColor = MaterialTheme.customColors.onDisabled,
    ),
    minLines: Int = ONE,
) {
    OutlinedTextField(
        modifier = modifier
            .wrapContentSize()
            .fillMaxWidth()
            .onFocusChanged { onFocusChanged(it) },
        value = value,
        onValueChange = onValueChange,
        enabled = enabled,
        isError = hasError,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        visualTransformation = visualTransformation,
        label = label,
        placeholder = placeholder,
        trailingIcon = trailingIcon,
        leadingIcon = leadingIcon,
        supportingText = supportingText,
        prefix = prefix,
        suffix = suffix,
        colors = colors,
        textStyle = MaterialTheme.typography.bodyMedium,
        shape = MaterialTheme.shapes.medium,
        minLines = minLines,
        singleLine = minLines == ONE,
    )
}

/** Input text field preview */
@Composable
@PreviewLightDark
private fun InputTextFieldPreview() {
    PokedexTheme {
        Surface(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            InputTextField(
                label = {
                    BasicText(
                        modifier = Modifier,
                        text = "Enter Phone Number",
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Medium,
                    )
                },
                supportingText = {
                    InputHelperText(text = "Helper text")
                },
                enabled = true,
                hasError = false,
                keyboardOptions = KeyboardOptions(),
                keyboardActions = KeyboardActions(),
                value = "",
                onValueChange = {},
                onFocusChanged = {},
                trailingIcon = {},
                prefix = {},
                suffix = {},
                modifier = Modifier.padding(16.dp),
            )
        }
    }
}
