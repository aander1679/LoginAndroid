package com.codeander.loginclases.repository

import com.codeander.loginclases.data.remote.ApiClient
import com.codeander.loginclases.data.remote.UserRequest
import com.codeander.loginclases.data.remote.UserResponse
import com.codeander.loginclases.data.remote.UserService
import com.codeander.loginclases.utils.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository (val userService: UserService = ApiClient.getUserService()){
    fun register(userRequest: UserRequest, callback: (Result<UserResponse>)->Unit){
        val register = userService.register(userRequest)
        register.enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful){
                    val userResponse= response.body()!!
                    callback(Result.Success(userResponse))
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                val message = t.message!!
                callback(Result.Error(message))
            }

        })
    }
}