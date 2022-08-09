package br.com.fcr.testapiviacep.presentation.viewmodel.model

import br.com.fcr.testapiviacep.data.model.dataModel
import br.com.fcr.testapiviacep.domain.model.UCModel

data class UiModel(
    val cep: String = "",
    val ddd: String = "",
    val localidade: String = "",
    val uf: String = ""
)
