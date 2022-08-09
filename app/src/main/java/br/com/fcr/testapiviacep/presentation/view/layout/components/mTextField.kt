package br.com.fcr.testapiviacep.presentation.view.layout.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.fcr.testapiviacep.presentation.view.ui.theme._16

@Composable
fun mTextField(value:String,label:String,onValueChange:(String)->Unit){
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label)},
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = _16)
    )
}