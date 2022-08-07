package br.com.fcr.testapiviacep.model.network

import br.com.fcr.testapiviacep.model.CEP
import br.com.fcr.testapiviacep.model.CEPLIST
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface InterfaceAPI {
    @GET("{CEP}/json/")
    fun getPlacebyCEP(
        @Path("CEP")
        CEP:String
    ):Call<CEP>

    @GET("{ESTADO}/{CIDADE}/{ENDERECO}/json/")
    fun getCEPbyPlace(
        @Path("ESTADO")ESTADO:String,
        @Path("CIDADE")CIDADE:String,
        @Path("ENDERECO")ENDERECO:String
    ):Call<CEPLIST>
}