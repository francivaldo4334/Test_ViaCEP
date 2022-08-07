package br.com.fcr.testapiviacep.view

import android.annotation.SuppressLint
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fcr.testapiviacep.model.CEP
import br.com.fcr.testapiviacep.view.layout.Layout_Home
import br.com.fcr.testapiviacep.view.layout.Layout_get_cep
import br.com.fcr.testapiviacep.view.layout.Layout_get_place_by_cep
import br.com.fcr.testapiviacep.view.layout.Layout_model
import br.com.fcr.testapiviacep.viewmodel.MyViewModel

class BaseAplication(){
    companion object{
        val myViewModel:MyViewModel = MyViewModel()
        var myitemModel:CEP by mutableStateOf(CEP())
        @SuppressLint("StaticFieldLeak")
        var navController:NavHostController? = null
    }
    @Composable
    fun myNavHost(){
        navController = rememberNavController()
        NavHost(navController = navController!!, startDestination = Screen.Home.route){
            composable(Screen.GetPlace.route){ Layout_get_place_by_cep() }
            composable(Screen.GetCEP.route){ Layout_get_cep() }
            composable(Screen.Home.route){ Layout_Home() }
            composable(Screen.Item.route){ Layout_model()}
        }
    }
}
sealed class Screen(val route:String) {
    object GetCEP:Screen("getCEP")
    object GetPlace:Screen("getPlace")
    object Home:Screen("HomePage")
    object Item:Screen("ItemPage")
}