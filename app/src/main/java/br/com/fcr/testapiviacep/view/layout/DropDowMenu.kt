package br.com.fcr.testapiviacep.view.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.fcr.testapiviacep.view.BaseAplication
import br.com.fcr.testapiviacep.view.Screen
import br.com.fcr.testapiviacep.view.ui.theme.*

@Composable
fun DropDowMenu() {
    val navController = BaseAplication.navController
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.TopStart)
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(_56)
                .background(MaterialTheme.colors.primary))
        {
            IconButton(onClick = {expanded = !expanded}) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = null)
            }

        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            DropdownMenuItem(onClick = {
                navController?.navigate(Screen.GetPlace.route){
                    popUpTo(Screen.GetPlace.route){inclusive = true}
                }
                expanded = false
            }) {
                Text(text = "Encontrar CEP com Endereco")
            }
            DropdownMenuItem(onClick = {
                navController?.navigate(Screen.GetCEP.route){
                    popUpTo(Screen.GetCEP.route){inclusive = true}
                }
                expanded = false
            }) {
                Text(text = "Encontrar Endereço com CEP")
            }
        }
    }
}