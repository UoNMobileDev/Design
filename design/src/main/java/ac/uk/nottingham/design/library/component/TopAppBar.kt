package ac.uk.nottingham.design.library.component

import ac.uk.nottingham.design.library.icon.AppIcons
import android.R
import androidx.annotation.StringRes
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.material3.Icon
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview

/**
 * Top app bar with action, displayed on the right
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopAppBar(
    @StringRes titleRes: Int,
    actionIcon: ImageVector,
    actionIconContentDescription: String?,
    modifier: Modifier= Modifier,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(),

    onActionClick: ()->Unit = {},

){
    CenterAlignedTopAppBar(
        title = { Text(text = stringResource(id = titleRes))},
        navigationIcon = {
            IconButton(onClick = onActionClick) {
                Icon(
                    imageVector = actionIcon,
                    contentDescription = actionIconContentDescription,
                    tint = MaterialTheme.colorScheme.onSurface,
                )
            }
        },
        colors = colors,
        modifier = modifier.testTag("appTopAppBar")
    )

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopAppBar(
    @StringRes titleRes: Int,
    navigationIcon: ImageVector,
    navigationIconContentDescription: String?,
    actionIcon: ImageVector,
    actionIconContentDescription: String?,
    modifier: Modifier = Modifier,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
    onNavigationClick: () -> Unit = {},
    onActionClick: () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        title = { Text(text = stringResource(id = titleRes)) },
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    imageVector = navigationIcon,
                    contentDescription = navigationIconContentDescription,
                    tint = MaterialTheme.colorScheme.onSurface,
                )
            }
        },
        actions = {
            IconButton(onClick = onActionClick) {
                Icon(
                    imageVector = actionIcon,
                    contentDescription = actionIconContentDescription,
                    tint = MaterialTheme.colorScheme.onSurface,
                )
            }
        },
        colors = colors,
        modifier = modifier.testTag("niaTopAppBar"),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview("Top App Bar")
@Composable
private fun NiaTopAppBarPreview() {
    AppTopAppBar(
        titleRes = R.string.untitled,
        navigationIcon = AppIcons.Search,
        navigationIconContentDescription = "Navigation icon",
        actionIcon = AppIcons.MoreVert,
        actionIconContentDescription = "Action icon",
    )
}