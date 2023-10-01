package com.codeander.loginclases.data.remote

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService {

    @POST("users")
    fun register(@Body userRequest: UserRequest ): Call<UserResponse>

}