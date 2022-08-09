package br.com.fcr.testapiviacep.presentation.view.layout

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import br.com.fcr.testapiviacep.presentation.view.layout.components.mTextField
import br.com.fcr.testapiviacep.presentation.view.ui.theme._16
import androidx.compose.ui.Modifier
import br.com.fcr.testapiviacep.presentation.view.BaseAplication
import br.com.fcr.testapiviacep.presentation.view.ui.theme.*

@Composable
fun Layout_get_cep() {
    var txtestado by remember { mutableStateOf("") }
    var txtcidade by remember { mutableStateOf("") }
    var txtendereco by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = _72, end = _16, start = _16)
    ) {
        mTextField(
            value = txtestado,
            label = "ESTADO_UF:",
            onValueChange = {txtestado = it}
        )
        mTextField(
            value = txtcidade,
            label = "CIDADE:",
            onValueChange = {txtcidade = it}
        )
        mTextField(
            value = txtendereco,
            label = "ENDERECO:",
            onValueChange = {txtendereco = it}
        )
        Spacer(modifier = Modifier.size(_56))
        LazyColumn(
            modifier = Modifier
                .weight(1.0f)
        ){
            items(BaseAplication.myViewModel.modelList){
                Item_model(item = it)
            }
        }
        Box(
            contentAlignment = Alignment.CenterEnd,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = _16)
        )
        {
            FloatingActionButton(onClick = {
                BaseAplication.myViewModel.getCEPbyPlace(txtestado,txtcidade,txtendereco)
            }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = null)
            }
        }
    }
}