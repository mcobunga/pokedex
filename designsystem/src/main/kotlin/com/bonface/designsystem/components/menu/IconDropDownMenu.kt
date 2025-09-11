package com.bonface.designsystem.components.menu

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.bonface.designsystem.R
import com.bonface.designsystem.components.text.BasicText
import com.bonface.designsystem.theme.PokedexTheme

/**
 * Icon drop down menu
 *
 * @param menuItems
 * @param expanded
 * @param onClick
 * @param onDismiss
 * @param modifier
 * @receiver
 * @receiver
 * @sample com.bonface.designsystem.components.menu.IconDropDownMenuPreview
 */
@Composable
fun IconDropDownMenu(
    menuItems: List<MenuItem>,
    expanded: Boolean,
    onClick: (MenuItem) -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
) = DropdownMenu(
    expanded = expanded,
    onDismissRequest = onDismiss,
    shape = MaterialTheme.shapes.large,
    shadowElevation = MenuDefaults.ShadowElevation,
    tonalElevation = MenuDefaults.TonalElevation,
    containerColor = MaterialTheme.colorScheme.background,
    modifier = modifier,
) {
    menuItems.forEach { menuItem ->
        DropdownMenuItem(
            text = {
                BasicText(
                    text = menuItem.label,
                    modifier = Modifier,
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                )
            },
            leadingIcon = {
                menuItem.iconRes?.let { iconRes ->
                    Icon(
                        imageVector = ImageVector.vectorResource(iconRes),
                        contentDescription = null,
                        tint = Color.Unspecified,
                    )
                }
            },
            contentPadding = PaddingValues(horizontal = 16.dp),
            onClick = { onClick(menuItem) },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
        )
    }
}

@Composable
@PreviewLightDark
private fun IconDropDownMenuPreview() {
    PokedexTheme {
        Surface {
            IconDropDownMenu(
                menuItems = listOf(
                    MenuItem(id = 1, label = "Call", iconRes = R.drawable.ic_search_normal),
                    MenuItem(id = 1, label = "Take Photo", iconRes = R.drawable.ic_action_back),
                ),
                expanded = true,
                modifier = Modifier.padding(16.dp),
                onClick = {},
                onDismiss = {},
            )
        }
    }
}
