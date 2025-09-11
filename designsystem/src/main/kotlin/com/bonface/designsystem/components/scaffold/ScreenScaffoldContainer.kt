package com.bonface.designsystem.components.scaffold

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.rememberNestedScrollInteropConnection
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.bonface.designsystem.components.buttons.PrimaryButton
import com.bonface.designsystem.components.buttons.SecondaryButton
import com.bonface.designsystem.components.menu.MenuActionStyle
import com.bonface.designsystem.components.menu.MenuActionStyleDefaults
import com.bonface.designsystem.components.modifiers.conditional
import com.bonface.designsystem.theme.PokedexTheme

/**
 * A composable function that provides a scaffold structure for a screen
 * with a customizable top app bar, bottom bar, and content area. It allows
 * for configuration of various UI properties including colors, actions,
 * and additional expanded content.
 *
 * @param screenTitle The title text to display in the top app bar of the
 *    screen.
 * @param onBack A lambda function invoked when the back or close action is
 *    triggered.
 * @param modifier The [Modifier] to be applied to the scaffold component.
 * @param titleColor The color of the title text in the top app bar.
 * @param containerColor The background color of the overall scaffold
 *    container.
 * @param surfaceColor The background color of the content area within the
 *    scaffold.
 * @param leftActionProperties Configuration for the left action icon in
 *    the top app bar.
 * @param menuActionStyle The style configuration for menu actions.
 * @param rightActions A list of composable functions to define
 *    right-aligned menu actions in the top app bar.
 * @param screenBottomBar A composable lambda defining the content of the
 *    bottom bar in the scaffold.
 * @param content A composable lambda representing the main body content of
 *    the scaffold.
 * @sample com.bonface.designsystem.components.scaffold.ScreenScaffoldContainerPreview
 */
@Composable
fun ScreenScaffoldContainer(
    modifier: Modifier = Modifier,
    screenTitle: String,
    onBack: () -> Unit = {},
    titleColor: Color = MaterialTheme.colorScheme.onBackground,
    containerColor: Color = MaterialTheme.colorScheme.background,
    surfaceColor: Color = MaterialTheme.colorScheme.background,
    leftActionProperties: LeftActionProperties = LeftActionPropertiesDefaults.default(),
    menuActionStyle: MenuActionStyle = MenuActionStyleDefaults.defaultStyle(iconTint = MaterialTheme.colorScheme.onBackground),
    rightActions: List<@Composable (MenuActionStyle) -> Unit> = emptyList(),
    screenBottomBar: @Composable () -> Unit = {},
    useSafeAreaPadding: Boolean = false,
    content: @Composable () -> Unit,
) {
    Scaffold(
        topBar = {
            ScreenTopBar(
                screenTitle = screenTitle,
                onBack = onBack,
                titleColor = titleColor,
                leftActionProperties = leftActionProperties,
                menuActionStyle = menuActionStyle,
                useSafeAreaPadding = useSafeAreaPadding,
                rightActions = rightActions,
            )
        },
        bottomBar = {
            ScreenBottomBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding(),
            ) { screenBottomBar() }
        },
        containerColor = containerColor,
        modifier = modifier
            .fillMaxSize()
            .imePadding(),
    ) { innerPadding ->
        Surface(
            color = surfaceColor,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .nestedScroll(rememberNestedScrollInteropConnection()),
        ) { content() }
    }
}

/**
 * Screen top bar
 *
 * @param screenTitle
 * @param onBack
 * @param titleColor
 * @param leftActionProperties
 * @param menuActionStyle
 * @param rightActions
 * @receiver
 */
@Composable
private fun ScreenTopBar(
    screenTitle: String,
    onBack: () -> Unit,
    titleColor: Color,
    leftActionProperties: LeftActionProperties,
    menuActionStyle: MenuActionStyle,
    useSafeAreaPadding: Boolean,
    rightActions: List<@Composable (MenuActionStyle) -> Unit>,
) {
    Box {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .conditional(useSafeAreaPadding) {
                    safeDrawingPadding()
                },
        ) {
            ScreenHeader(
                title = screenTitle,
                onClose = onBack,
                titleColor = titleColor,
                menuActionStyle = menuActionStyle,
                leftIconProperties = leftActionProperties,
                rightActions = rightActions,
            )
        }
    }
}

/**
 * Screen bottom bar
 *
 * @param content
 * @receiver
 */
@Composable
private fun ScreenBottomBar(
    modifier: Modifier = Modifier,
    content: @Composable (Modifier) -> Unit,
) = content(modifier)

/** Screen scaffold container preview */
@Composable
@PreviewLightDark
private fun ScreenScaffoldContainerPreview() {
    PokedexTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            ScreenScaffoldContainer(
                screenTitle = "Send Money",
                onBack = {},
                screenBottomBar = {},
            ) {
                // Screen Contents
            }
        }
    }
}

/** Screen scaffold container w ith bottom bar preview */
@Composable
@PreviewLightDark
private fun ScreenScaffoldContainerWithBottomBarPreview() {
    PokedexTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            ScreenScaffoldContainer(
                screenTitle = "Send Money",
                onBack = {},
                screenBottomBar = {
                    ScreenBottomBarActions(
                        actions = listOf(
                            { SecondaryButton(modifier = Modifier.weight(1F), text = "Cancel", onClick = {}) },
                            { PrimaryButton(modifier = Modifier.weight(1F), text = "Retry", onClick = {}) },
                        ),
                    )
                },
            ) {
                // Screen Contents
            }
        }
    }
}
