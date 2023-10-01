package com.codeander.loginclases.ui.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codeander.loginclases.data.remote.UserRequest
import com.codeander.loginclases.repository.UserRepository

class SignUpViewModel(val userRepository: UserRepository = UserRepository()): ViewModel() {
     private var _username = MutableLiveData<String>()
     val username get()= _username

     fun updateUserName(username: String){
          _username.value=username
     }

     private var _password = MutableLiveData<String>()

     val password get()= _password
     fun updatePassword(password: String){
          _password.value=password
     }

     fun register(username: String, password:String){

          val userRequest = UserRequest(username,password)
          userRepository.register(userRequest){

          }
     }
}