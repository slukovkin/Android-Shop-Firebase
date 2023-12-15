package com.all4drive.shop.view.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.all4drive.shop.models.DrawerItemModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerComponent(drawerState: DrawerState, scope: CoroutineScope) {
    val itemsMenu = listOf<DrawerItemModel>(
        DrawerItemModel(
            Icons.Default.AccountCircle,
            "Аккаунт"
        ),
        DrawerItemModel(
            Icons.Default.Favorite,
            "Избранные",
        ),
        DrawerItemModel(
            Icons.Default.List,
            "Товар",
        ),
        DrawerItemModel(
            Icons.Default.Settings,
            "Настройки"
        )
    )
//    val scope = rememberCoroutineScope()
//    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var selectItem by remember {
        mutableStateOf(itemsMenu[0])
    }
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                DrawerHeader()
                Spacer(modifier = Modifier.height(10.dp))
                itemsMenu.forEach {
                    NavigationDrawerItem(
                        modifier = Modifier
                            .padding(5.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(5.dp),
                        icon = {
                            Icon(imageVector = it.imageVector, contentDescription = it.title)
                        },
                        label = {
                            Text(text = it.title)
                        },
                        selected = selectItem == it,
                        onClick = {
                            scope.launch {
                                selectItem = it
                                drawerState.close()
                            }
                        })
                }
            }
        },
        content = {

        }
    )
}

@Composable
fun DrawerHeader() {
    Column(
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxSize()
            .background(Color.Black)
            .height(150.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "USER SETTINGS",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }
    }
}
