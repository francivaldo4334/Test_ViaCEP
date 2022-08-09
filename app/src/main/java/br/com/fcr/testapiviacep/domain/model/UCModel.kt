package br.com.fcr.testapiviacep.domain.model

import br.com.fcr.testapiviacep.data.model.dataModel
import br.com.fcr.testapiviacep.presentation.viewmodel.model.UiModel

data class UCModel(
    val cep: String = "",
    val ddd: String = "",
    val localidade: String = "",
    val uf: String = ""
)
fun UCModel.toUiModel() = UiModel(
    cep = this.cep,
    ddd = this.ddd,
    localidade = this.localidade,
    uf = this.uf
)