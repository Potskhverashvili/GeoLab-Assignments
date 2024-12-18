package com.example.cocktailapp.core

sealed interface OperationStatus<SuccessType> {
    data class Success<SuccessType>(val value: SuccessType) : OperationStatus<SuccessType>
    data class Failure<SuccessType>(val exception: Exception) : OperationStatus<SuccessType>
}

// -------------------- Mapper ----------------------
fun <FromType, ToType> OperationStatus<FromType>.map(
    mapper: (FromType) -> ToType,
): OperationStatus<ToType> {
    return when (this) {
        is OperationStatus.Success -> OperationStatus.Success(mapper(value))
        is OperationStatus.Failure -> OperationStatus.Failure(exception)
    }
}


// ------------------- For View Model -----------------
suspend fun <T> OperationStatus<T>.onSuccess(action: suspend (T) -> Unit): OperationStatus<T> {
    if (this is OperationStatus.Success) {
        action(this.value)
    }
    return this
}

suspend fun <T> OperationStatus<T>.onFailure(action: suspend (Exception) -> Unit): OperationStatus<T> {
    if (this is OperationStatus.Failure) {
        action(this.exception)
    }
    return this
}