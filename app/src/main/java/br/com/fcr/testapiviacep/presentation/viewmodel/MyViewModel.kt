package br.com.fcr.testapiviacep.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fcr.testapiviacep.data.model.dataModel
import br.com.fcr.testapiviacep.data.model.dataModelList
import br.com.fcr.testapiviacep.data.MyRetrofit
import br.com.fcr.testapiviacep.domain.UserCase
import br.com.fcr.testapiviacep.domain.model.toUiModel
import br.com.fcr.testapiviacep.domain.model.toUiModelList
import br.com.fcr.testapiviacep.presentation.viewmodel.model.UiModel
import br.com.fcr.testapiviacep.presentation.viewmodel.model.UiModelList
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyViewModel:ViewModel() {
    var modelList:UiModelList by mutableStateOf(UiModelList())
    var model:UiModel by mutableStateOf(UiModel())
    var errorMessage:String by mutableStateOf("")
    private val TAG = "VM"

    fun getPlacebyCEP(CEP:String){

        viewModelScope.launch {
            val result = UserCase().getPlacebyCep(CEP) //MyRetrofit().apiService().getPlacebyCEP(CEP)
            try {
                model = result.toUiModel()
            }catch (e:Exception){
                Log.i("TAG","error")
            }
        }
//        call.enqueue(object : Callback<dataModel>{
//            override fun onResponse(call: Call<dataModel>, response: Response<dataModel>) {
//                try {
//                    model = response.body()!!
//                    Log.d(TAG,model.localidade)
//                }catch (e:Exception){
//                    errorMessage = e.message.toString()
//                    Log.i(TAG,errorMessage)
//                }
//            }
//
//            override fun onFailure(call: Call<dataModel>, t: Throwable) {
//                errorMessage = t.message.toString()
//                Log.i(TAG,errorMessage)
//            }
//        })
    }
    fun getCEPbyPlace(ESTADO:String,CIDADE:String,ENDERECO: String){
        viewModelScope.launch {
            val result = UserCase().getCepbyPlace(ESTADO,CIDADE,ENDERECO) //MyRetrofit().apiService().getPlacebyCEP(CEP)
            try {
                modelList = result.toUiModelList()
            }catch (e:Exception){
                Log.i("TAG","error")
            }
        }
//        val call = UserCase().getCepbyPlace(ESTADO,CIDADE,ENDERECO)//MyRetrofit().apiService().getCEPbyPlace(ESTADO,CIDADE,ENDERECO)
//        call.enqueue(object : Callback<dataModelList>{
//            override fun onResponse(call: Call<dataModelList>, response: Response<dataModelList>) {
//                try {
//                    modelList = response.body()!!
//                    Log.i(TAG,modelList.toString())
//                }catch (e:Exception){
//                    errorMessage = e.message.toString()
//                    Log.i(TAG,errorMessage)
//                }
//            }
//
//            override fun onFailure(call: Call<dataModelList>, t: Throwable) {
//                errorMessage = t.message.toString()
//                Log.i(TAG,errorMessage)
//            }
//        })
    }
}