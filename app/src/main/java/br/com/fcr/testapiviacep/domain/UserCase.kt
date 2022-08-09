package br.com.fcr.testapiviacep.domain

import br.com.fcr.testapiviacep.data.MyRetrofit
import br.com.fcr.testapiviacep.data.model.dataModel
import br.com.fcr.testapiviacep.data.model.dataModelList
import br.com.fcr.testapiviacep.data.model.toUCModel
import br.com.fcr.testapiviacep.data.model.toUCModelList
import br.com.fcr.testapiviacep.domain.model.UCModel
import br.com.fcr.testapiviacep.domain.model.UCModelList

class UserCase :UserCaseInterface {
    override suspend fun getPlacebyCep(CEP: String): UCModel {
        return MyRetrofit().apiService().getPlacebyCEP(CEP).toUCModel()
    }

    override suspend fun getCepbyPlace(
        ESTADO: String,
        CIDADE: String,
        ENDERECO: String
    ): UCModelList {
        return MyRetrofit().apiService().getCEPbyPlace(ESTADO,CIDADE,ENDERECO).toUCModelList()
    }
}
interface UserCaseInterface{
    suspend fun getPlacebyCep(
        CEP:String
    ): UCModel
    suspend fun getCepbyPlace(
        ESTADO:String,
        CIDADE:String,
        ENDERECO:String
    ): UCModelList
}