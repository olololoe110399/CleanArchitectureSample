package com.sun_asterisk.clean_architecture_sample2.domain.usecase.base

interface UseCaseResponse<Type> {

    fun onSuccess(result: Type)

    fun onError(errorMsg: String?)
}
