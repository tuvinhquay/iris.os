package com.irisos.core.domain

import com.irisos.core.logs.IRISLogger

abstract class BaseUseCase<in P, out R> {
    abstract suspend fun execute(parameters: P): R

    protected fun logExecution(name: String) {
        IRISLogger.runtime("Executing UseCase: $name")
    }
}