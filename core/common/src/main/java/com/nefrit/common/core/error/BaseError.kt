package com.nefrit.common.core.error

import java.io.IOException

class BaseError(
    val kind: Kind,
    message: String,
    exception: Throwable? = null
) : RuntimeException(message, exception) {

    enum class Kind {
        BUSINESS,
        NETWORK,
        HTTP,
        UNEXPECTED
    }

    companion object {

        fun business(message: String): BaseError {
            return BaseError(Kind.BUSINESS, message)
        }

        fun connection(errorCode: Int, message: String): BaseError {
            return BaseError(Kind.HTTP, message)
        }

        fun network(message: String, exception: IOException): BaseError {
            return BaseError(Kind.NETWORK, message, exception)
        }

        fun unexpected(exception: Throwable): BaseError {
            return BaseError(Kind.UNEXPECTED, exception.message ?: "", exception)
        }
    }
}