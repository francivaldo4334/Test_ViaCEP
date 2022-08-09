package br.com.fcr.testapiviacep.data.model

import br.com.fcr.testapiviacep.domain.model.UCModel

data class dataModel(
    val bairro: String = "",
    val cep: String = "",
    val complemento: String = "",
    val ddd: String = "",
    val gia: String = "",
    val ibge: String = "",
    val localidade: String = "",
    val logradouro: String = "",
    val siafi: String = "",
    val uf: String = ""
)
fun dataModel.toUCModel() = UCModel(
    cep = this.cep,
    ddd = this.ddd,
    localidade = this.localidade,
    uf = this.uf
)