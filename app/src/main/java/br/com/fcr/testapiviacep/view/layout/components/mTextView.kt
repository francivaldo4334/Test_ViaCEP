package br.com.fcr.testapiviacep.view.layout.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import br.com.fcr.testapiviacep.view.ui.theme._16

@Composable
fun mTextView(title:String,text:String){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = _16)
    ) {
        Text(text = title, fontSize = 12.sp)
        Spacer(modifier = Modifier.size(_16))
        Text(text = text, fontSize = 18.sp, fontWeight = FontWeight.Bold)
    }
}