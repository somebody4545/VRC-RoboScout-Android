package com.sunkensplashstudios.VRCRoboScout

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun FavoritesView() {

    val localContext = LocalContext.current
    val favorites = remember { UserSettings(localContext).getData("favorites", "").replace("[", "").replace("]", "").split(", ") }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(0.dp),
            modifier = Modifier.padding(10.dp)
        ) {
            items(favorites) { favorite ->
                Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.padding(10.dp)) {
                    Text(favorite)
                    Spacer(modifier = Modifier.weight(1.0f))
                }
                if (favorites.indexOf(favorite) < favorites.size - 1) {
                    Divider(color = MaterialTheme.colorScheme.primary, thickness = 1.dp)
                }
            }
        }
    }
}