package com.codeander.loginclases

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.codeander.loginclases.ui.signup.SignUp
import com.codeander.loginclases.ui.theme.LoginClasesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginClasesTheme {
                // A surface container using the 'background' color from the theme
                SignUp()
            }
        }
    }
}

