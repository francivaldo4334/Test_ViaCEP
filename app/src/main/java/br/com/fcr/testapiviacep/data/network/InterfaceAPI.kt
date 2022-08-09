package br.com.fcr.testapiviacep.data.network

import br.com.fcr.testapiviacep.data.model.dataModel
import br.com.fcr.testapiviacep.data.model.dataModelList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface InterfaceAPI {
    @GET("{CEP}/json/")
    suspend fun getPlacebyCEP(
        @Path("CEP")
        CEP:String
    ):dataModel

    @GET("{ESTADO}/{CIDADE}/{ENDERECO}/json/")
    suspend fun getCEPbyPlace(
        @Path("ESTADO")ESTADO:String,
        @Path("CIDADE")CIDADE:String,
        @Path("ENDERECO")ENDERECO:String
    ):dataModelList
}