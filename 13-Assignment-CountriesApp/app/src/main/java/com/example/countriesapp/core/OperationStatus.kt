package com.example.countriesapp.core

sealed interface OperationStatus<T> {
    data class Success<T>(val value: T) : OperationStatus<T>
    data class Failure<T>(val exception: Exception) : OperationStatus<T>
}


// -------------- Mapper --------------
fun <FromType, ToType> OperationStatus<FromType>.map(
    mapper : (FromType) -> ToType
) : OperationStatus<ToType> {
    return when(this){
        is OperationStatus.Success -> OperationStatus.Success(mapper(value))
        is OperationStatus.Failure -> OperationStatus.Failure(exception)
    }
}

// --------------------------For ViewModel ------------------------------
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

