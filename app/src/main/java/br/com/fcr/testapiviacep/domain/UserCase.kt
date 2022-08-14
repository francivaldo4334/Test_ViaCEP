package br.com.fcr.testapiviacep.domain

import br.com.fcr.testapiviacep.data.MyRetrofit
import br.com.fcr.testapiviacep.data.model.toUCModel
import br.com.fcr.testapiviacep.data.model.toUCModelList
import br.com.fcr.testapiviacep.domain.model.UCModel
import br.com.fcr.testapiviacep.domain.model.UCModelList

class UserCase :UserCaseInterface {
    override suspend fun getPlacebyCep(CEP: String): UCModel {
        return try {
            MyRetrofit.apiService().getPlacebyCEP(CEP).toUCModel()
        }catch (e:Exception){
            UCModel()
        }
    }

    override suspend fun getCepbyPlace(
        ESTADO: String,
        CIDADE: String,
        ENDERECO: String
    ): UCModelList {
        return try {
            MyRetrofit.apiService().getCEPbyPlace(ESTADO,CIDADE,ENDERECO).toUCModelList()
        }catch (e:Exception){
            UCModelList()
        }
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