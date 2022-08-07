package br.com.fcr.testapiviacep.view.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import br.com.fcr.testapiviacep.view.BaseAplication
import br.com.fcr.testapiviacep.view.layout.DropDowMenu
import br.com.fcr.testapiviacep.view.ui.theme.TestAPIViaCEPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestAPIViaCEPTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    BaseAplication().myNavHost()
                    DropDowMenu()
                }
            }
        }
    }
}