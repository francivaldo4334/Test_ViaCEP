package br.com.fcr.testapiviacep.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import br.com.fcr.testapiviacep.model.CEP
import br.com.fcr.testapiviacep.model.CEPLIST
import br.com.fcr.testapiviacep.model.network.MyRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyViewModel:ViewModel() {
    var placeResList:CEPLIST by mutableStateOf(CEPLIST())
    var placeRes:CEP by mutableStateOf(CEP())
    var errorMessage:String by mutableStateOf("")
    private val TAG = "VM"

    fun getPlacebyCEP(CEP:String){
        val call = MyRetrofit().apiService().getPlacebyCEP(CEP)
        call.enqueue(object : Callback<CEP>{
            override fun onResponse(call: Call<CEP>, response: Response<CEP>) {
                try {
                    placeRes = response.body()!!
                    Log.d(TAG,placeRes.localidade)
                }catch (e:Exception){
                    errorMessage = e.message.toString()
                    Log.i(TAG,errorMessage)
                }
            }

            override fun onFailure(call: Call<CEP>, t: Throwable) {
                errorMessage = t.message.toString()
                Log.i(TAG,errorMessage)
            }
        })
    }
    fun getCEPbyPlace(ESTADO:String,CIDADE:String,ENDERECO: String){
        val call = MyRetrofit().apiService().getCEPbyPlace(ESTADO,CIDADE,ENDERECO)
        call.enqueue(object : Callback<CEPLIST>{
            override fun onResponse(call: Call<CEPLIST>, response: Response<CEPLIST>) {
                try {
                    placeResList = response.body()!!
                    Log.i(TAG,placeResList.toString())
                }catch (e:Exception){
                    errorMessage = e.message.toString()
                    Log.i(TAG,errorMessage)
                }
            }

            override fun onFailure(call: Call<CEPLIST>, t: Throwable) {
                errorMessage = t.message.toString()
                Log.i(TAG,errorMessage)
            }
        })
    }
}