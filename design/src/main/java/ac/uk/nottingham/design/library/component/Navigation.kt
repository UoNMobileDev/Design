package ac.uk.nottingham.design.library.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * App navigation bar with content slot. Wraps Material 3 [NavigationBar].
 *
 * @param modifier Modifier to be applied to the navigation bar.
 * @param content Destinations inside the navigation bar. This should contain multiple
 * [NavigationBarItem]s.
 */
@Composable
fun AppNavigationBar(
    modifier: Modifier = Modifier,
    content:@Composable RowScope.()->Unit,
){
    NavigationBar(
        modifier = modifier,
        contentColor = AppNavigationDefaults.navigationContentColor(),
        tonalElevation = 0.dp,
        content = content,
    )
}

@Composable
fun RowScope.AppNavigationBarItem (
    selected : Boolean,
    onClick: ()->Unit,
    icon: @Composable ()-> Unit,
    modifier: Modifier = Modifier,
    selectedIcon: @Composable ()-> Unit = icon,
    enabled: Boolean = true,
    label: @Composable (()->Unit)?= null,
    alwaysShowLabel: Boolean = true,
){
    NavigationBarItem(
        selected =selected,
        onClick = onClick,
        icon = if (selected) selectedIcon else icon,
        modifier = modifier,
        enabled = enabled,
        label =label,
        alwaysShowLabel = alwaysShowLabel,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = AppNavigationDefaults.navigationSelectedItemColor(),
            unselectedIconColor = AppNavigationDefaults.navigationContentColor(),
            selectedTextColor = AppNavigationDefaults.navigationSelectedItemColor(),
            unselectedTextColor = AppNavigationDefaults.navigationContentColor(),
            indicatorColor = AppNavigationDefaults.navigationIndicatorColor(),
        )

    )
}
/**
 * App navigation rail with header and content slots. Wraps Material 3 [NavigationRail].
 *
 * @param modifier Modifier to be applied to the navigation rail.
 * @param header Optional header that may hold a floating action button or a logo.
 * @param content Destinations inside the navigation rail. This should contain multiple
 * [NavigationRailItem]s.
 */
@Composable
fun AppNavigationRail (
    modifier: Modifier = Modifier,
    header: @Composable (ColumnScope.() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
){
    NavigationRail(
        modifier = modifier,
        containerColor = Color.Transparent,
        contentColor= AppNavigationDefaults.navigationContentColor(),
        header = header,
        content= content,
    )
}

object AppNavigationDefaults {
    @Composable
    fun navigationContentColor() = MaterialTheme.colorScheme.onSurfaceVariant

    @Composable
    fun navigationSelectedItemColor() = MaterialTheme.colorScheme.onPrimaryContainer

    @Composable
    fun navigationIndicatorColor() = MaterialTheme.colorScheme.primaryContainer
}