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
            val result = UserCase().getPlacebyCep(CEP)
            try {
                model = result.toUiModel()
            }catch (e:Exception){
                errorMessage = e.message.toString()
                Log.i(TAG,"error")
            }
        }
    }
    fun getCEPbyPlace(ESTADO:String,CIDADE:String,ENDERECO: String){
        viewModelScope.launch {
            val result = UserCase().getCepbyPlace(ESTADO,CIDADE,ENDERECO)
            try {
                modelList = result.toUiModelList()
            }catch (e:Exception){
                errorMessage = e.message.toString()
                Log.i(TAG,"error")
            }
        }
    }
}