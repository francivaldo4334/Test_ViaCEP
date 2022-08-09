package br.com.fcr.testapiviacep.presentation.view.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.fcr.testapiviacep.presentation.view.BaseAplication
import br.com.fcr.testapiviacep.presentation.view.layout.components.mTextView
import br.com.fcr.testapiviacep.presentation.view.ui.theme.*

@Composable
fun Layout_model(){
    val item = BaseAplication.myitemModel
    Column(
        Modifier.padding(top = _72, start = _16, end = _16)
    ) {
        mTextView(title = "CEP:", text = item.cep)
        mTextView(title = "DDD:", text = item.ddd)
        mTextView(title = "ESTADO:", text = item.uf)
        mTextView(title = "CIDADE:", text = item.localidade)
    }
}