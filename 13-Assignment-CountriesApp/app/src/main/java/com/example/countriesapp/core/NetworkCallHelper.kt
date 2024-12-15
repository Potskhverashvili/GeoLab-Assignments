package com.example.countriesapp.core

import retrofit2.Response

object NetworkCallHelper {
    suspend fun <T> safeApi(apiCall: suspend () -> Response<T>): OperationStatus<T> {
        return try {
            OperationStatus.Success(apiCall().body()!!)
        } catch (e: Exception) {
            OperationStatus.Failure(e)
        }
    }
}