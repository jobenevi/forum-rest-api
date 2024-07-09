package com.api.forum.rest.api.mapper

interface Mapper<T, U> {

    fun map(t: T): U

}
