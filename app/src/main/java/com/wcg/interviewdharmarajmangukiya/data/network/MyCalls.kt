package com.wcg.interviewdharmarajmangukiya.data.network

import com.wcg.interviewdharmarajmangukiya.data.network.responses.BreedResponse
import com.wcg.interviewdharmarajmangukiya.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MyCalls {
    @GET(Constants.ApiValues.BREEDS)
    suspend fun getBreedsCall(
        @Query("page") page: String?,
        @Query("limit") limit: String?,
    ): Response<BreedResponse>
}