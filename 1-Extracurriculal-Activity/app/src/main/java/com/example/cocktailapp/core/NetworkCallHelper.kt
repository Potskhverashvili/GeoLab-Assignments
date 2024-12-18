package com.example.cocktailapp.core

import retrofit2.Response

object NetworkCallHelper {
    suspend fun <SuccessType> safeApiCall(
        apiCall: suspend () -> Response<SuccessType>,
    ): OperationStatus<SuccessType> {
        return try {
            OperationStatus.Success(apiCall().body()!!)
        } catch (e: Exception) {
            OperationStatus.Failure(e)
        }
    }
}