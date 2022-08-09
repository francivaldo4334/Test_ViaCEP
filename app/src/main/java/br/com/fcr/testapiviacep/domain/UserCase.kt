package br.com.fcr.testapiviacep.domain

import br.com.fcr.testapiviacep.common.Resource
import br.com.fcr.testapiviacep.data.MyRetrofit
import br.com.fcr.testapiviacep.data.model.dataModel
import br.com.fcr.testapiviacep.data.model.dataModelList
import br.com.fcr.testapiviacep.data.model.toUCModel
import br.com.fcr.testapiviacep.data.model.toUCModelList
import br.com.fcr.testapiviacep.domain.model.UCModel
import br.com.fcr.testapiviacep.domain.model.UCModelList
import br.com.fcr.testapiviacep.presentation.viewmodel.model.UiModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserCase :UserCaseInterface {
    override suspend fun getPlacebyCep(CEP: String): UCModel {
        return try {
            MyRetrofit().apiService().getPlacebyCEP(CEP).toUCModel()
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
            MyRetrofit().apiService().getCEPbyPlace(ESTADO,CIDADE,ENDERECO).toUCModelList()
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