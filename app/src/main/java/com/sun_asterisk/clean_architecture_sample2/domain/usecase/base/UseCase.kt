package com.sun_asterisk.clean_architecture_sample2.domain.usecase.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import java.util.concurrent.CancellationException

abstract class UseCase<Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Type

    @ExperimentalCoroutinesApi
    fun invoke(
        params: Params,
        onResult: (UseCaseResponse<Type>)?
    ) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val result = run(params)
                onResult?.onSuccess(result)
            } catch (e: CancellationException) {
                onResult?.onError(e.message)
            } catch (e: Exception) {
                onResult?.onError(e.message)
            }
        }
    }
}
