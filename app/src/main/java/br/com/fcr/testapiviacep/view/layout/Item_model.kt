package br.com.fcr.testapiviacep.view.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fcr.testapiviacep.model.CEP
import br.com.fcr.testapiviacep.view.BaseAplication
import br.com.fcr.testapiviacep.view.Screen
import br.com.fcr.testapiviacep.view.ui.theme.*

@Composable
fun Item_model(item:CEP){
    BaseAplication.myitemModel = item
    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = _16)
            .clickable{
                BaseAplication.navController?.navigate(Screen.Item.route)
            }
    ) {
        Spacer(modifier = Modifier.size(_16))
        Text(text = "${item.localidade} - ${item.uf}", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.size(_8))
        Text(text = "CEP = ${item.cep}", fontSize = 12.sp)
        Spacer(modifier = Modifier.size(_16))
        Box(modifier = Modifier.height(2.dp).fillMaxWidth().background(Color.Black.copy(alpha = 0.2f)))
    }
}