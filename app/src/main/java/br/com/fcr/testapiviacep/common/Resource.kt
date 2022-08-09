package br.com.fcr.testapiviacep.common

sealed class Resource<T>(val data:T? = null,val messge:String? = null){
    class Sucess<T>(data: T):Resource<T>(data)
    class Error<T>(data: T? = null,messge: String):Resource<T>(data,messge)
    class Loading<T>(data: T? = null):Resource<T>(data)
}