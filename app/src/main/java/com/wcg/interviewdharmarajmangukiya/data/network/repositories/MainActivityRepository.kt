package com.wcg.interviewdharmarajmangukiya.data.network.repositories

import android.content.Context
import com.wcg.interviewdharmarajmangukiya.data.SafeApiRequest
import com.wcg.interviewdharmarajmangukiya.utils.selectApi

class MainActivityRepository(
    private val context: Context
) : SafeApiRequest() {
    suspend fun getBreedsCall(pageCount: String, listLimit: String) = apiRequest {
        context.selectApi()?.getBreedsCall(pageCount, listLimit)
    }
}