package com.bonface.designsystem.components.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import com.bonface.designsystem.components.buttons.ShadowIconButton
import com.bonface.designsystem.extensions.dimensions

/**
 * A composable function that displays a "more" menu (typically a vertical ellipsis menu).
 *
 * This composable provides a highly customizable button to toggle the visibility of a
 * dropdown menu containing a list of [MenuItem]s. It uses a [MoreMenuExpandedState] to
 * manage the expanded/collapsed state of the menu.
 *
 * @param expandedState The [MoreMenuExpandedState] instance that manages the expanded/collapsed
 *        state of the menu.
 * @param menuActionIcon The [Painter] to use for the icon of the menu action button.
 *        This allows for complete customization of the icon.
 * @param menuActionContentDescription The content description for the menu action button.
 *        This is used for accessibility purposes.
 * @param menuItems The list of [MenuItem]s to display in the dropdown menu.
 * @param onMenuItemClick A callback function that is invoked when a [MenuItem] is clicked.
 *        The clicked [MenuItem] is passed as a parameter to this callback.
 * @param modifier An optional [Modifier] to apply to the root [Column] of the menu.
 * @param menuActionStyle The [MenuActionStyle] to use for styling the menu action button.
 *        This allows for customization of the icon tint and container color.
 *        Defaults to [MenuActionStyleDefaults.onSurface].
 *
 * @see MoreMenuExpandedState
 * @see MenuItem
 * @see MenuActionStyle
 * @see MenuActionStyleDefaults
 */
@Composable
fun MoreMenu(
    expandedState: MoreMenuExpandedState,
    menuActionIcon: Painter,
    menuActionContentDescription: String,
    menuItems: List<MenuItem>,
    onMenuItemClick: (MenuItem) -> Unit,
    modifier: Modifier = Modifier,
    menuActionStyle: MenuActionStyle = MenuActionStyleDefaults.defaultStyle(),
) {
    Column(modifier = modifier) {
        ShadowIconButton(
            icon = menuActionIcon,
            iconTint = menuActionStyle.iconTint,
            containerColor = menuActionStyle.containerColor,
            shadowOffsetX = (-MaterialTheme.dimensions.xSmall),
            shadowOffsetY = MaterialTheme.dimensions.medium,
            shadowBlurRadius = MaterialTheme.dimensions.xLarge,
            contentDescription = menuActionContentDescription,
            onClick = { expandedState.toggleExpanded() },
        )
        IconDropDownMenu(
            menuItems = menuItems,
            expanded = expandedState.expanded,
            onClick = {
                expandedState.toggleExpanded()
                onMenuItemClick(it)
            },
            onDismiss = { expandedState.toggleExpanded() },
        )
    }
}
