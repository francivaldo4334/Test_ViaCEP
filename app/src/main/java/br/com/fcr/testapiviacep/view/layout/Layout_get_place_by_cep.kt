package br.com.fcr.testapiviacep.view.layout

import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.fcr.testapiviacep.view.BaseAplication
import br.com.fcr.testapiviacep.view.layout.components.mTextField
import br.com.fcr.testapiviacep.view.ui.theme._16
import br.com.fcr.testapiviacep.view.ui.theme._56
import br.com.fcr.testapiviacep.view.ui.theme._72

@Composable
fun Layout_get_place_by_cep(){
    var txtCEP by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = _72, end = _16, start = _16)
    ) {
        mTextField(
            value = txtCEP,
            label = "CEP:",
            onValueChange = {txtCEP = it}
        )
        Spacer(modifier = Modifier.size(_56))
        Item_model(BaseAplication.myViewModel.placeRes)
        Spacer(modifier = Modifier.weight(1.0f))
        Box(
            contentAlignment = Alignment.CenterEnd,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = _16)
        ){
            FloatingActionButton(onClick = {
                BaseAplication.myViewModel.getPlacebyCEP(txtCEP)
            }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            }
        }
    }
}