package br.com.fcr.testapiviacep.presentation.view.layout

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
import br.com.fcr.testapiviacep.data.model.dataModel
import br.com.fcr.testapiviacep.presentation.view.BaseAplication
import br.com.fcr.testapiviacep.presentation.view.Screen
import br.com.fcr.testapiviacep.presentation.view.ui.theme.*
import br.com.fcr.testapiviacep.presentation.viewmodel.model.UiModel
import br.com.fcr.testapiviacep.presentation.viewmodel.model.UiModelList

@Composable
fun Item_model(item: UiModel){
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