package com.example.app_hearify.userView

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.app_hearify.ui.theme.App_HearifyTheme

@Composable
fun ThumbnailsUserProfile(modifier: Modifier = Modifier) {

}

@Composable
fun BoxIcon(
    modifier: Modifier = Modifier,
    icon: ImageVector = Icons.Filled.AccountCircle
) {
    Box(modifier = modifier.fillMaxHeight()) {
        icon
    }
}

@Composable
fun DashboardScreen() {
    App_HearifyTheme {
        ThumbnailsUserProfile(modifier = Modifier)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UserScreenPreview() {
    App_HearifyTheme {
        ThumbnailsUserProfile(modifier = Modifier)
    }
}