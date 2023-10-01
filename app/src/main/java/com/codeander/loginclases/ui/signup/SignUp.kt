package com.codeander.loginclases.ui.signup

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.codeander.loginclases.data.remote.UserRequest
import com.codeander.loginclases.repository.UserRepository
import com.codeander.loginclases.utils.Result

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUp(){
    val username = remember { mutableStateOf("")}
    val password = remember{ mutableStateOf("")}
    val confirmPassword = remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(value = username.value,
            onValueChange = {newValue ->
                username.value = newValue
            },
            placeholder = {Text(text = "username")}, modifier = Modifier.fillMaxWidth())

        OutlinedTextField(value = password.value,
            onValueChange = { newValue->
                password.value=newValue
            },
            visualTransformation = PasswordVisualTransformation(),
            placeholder = { Text(text = "password")},modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = confirmPassword.value,
            onValueChange = { newValue->
                confirmPassword.value=newValue
            },
            visualTransformation = PasswordVisualTransformation(),

            placeholder = { Text(text = "confirmPassword")},modifier = Modifier.fillMaxWidth())
        val userRepository= UserRepository()
        val userRequest= UserRequest(username.value, password.value)
        val context = LocalContext.current
        Button(onClick = {

            userRepository.register(userRequest){result ->
            if (result is Result.Success){
                val id = result.data!!.id
                Toast.makeText(context, "$id",Toast.LENGTH_SHORT).show()
            }

            }
        }){
            Text(text = "Register")
        }

        TextButton(onClick = { }) {
            Text( "Login")
        }
    }





}

@Preview
@Composable
fun SignUpPreview(){
    SignUp()
}