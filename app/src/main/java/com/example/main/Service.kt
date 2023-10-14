package com.example.main

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface Service {

    @POST("/v1/member/register")
    fun login(
        @Body loginRequestData: LoginReqeust
    ) : Call<LoginResponse>

}