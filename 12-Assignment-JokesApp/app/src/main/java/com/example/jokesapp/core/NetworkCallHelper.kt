package com.example.jokesapp.core

import retrofit2.Response

object NetworkCallHelper {
    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): OperationStatus<T> {
        return try {
            OperationStatus.Success(apiCall().body()!!)
        } catch (e: Exception) {
            OperationStatus.Failure(e)
        }
    }
}