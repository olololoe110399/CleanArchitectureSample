package com.sun_asterisk.clean_architecture_sample2.domain.model

interface MappableData<T> {
    fun map(): T
}
