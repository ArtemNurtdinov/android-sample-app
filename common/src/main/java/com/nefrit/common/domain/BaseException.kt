package com.nefrit.common.domain

import com.nefrit.common.R
import com.nefrit.common.resources.ResourceManager
import java.io.IOException

class BaseException(
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

        fun businessError(message: String): BaseException {
            return BaseException(Kind.BUSINESS, message)
        }

        fun httpError(resourceManager: ResourceManager): BaseException {
            return BaseException(Kind.HTTP, resourceManager.getString(R.string.common_error_general_message))
        }

        fun networkError(resourceManager: ResourceManager, exception: IOException): BaseException {
            return BaseException(Kind.NETWORK, resourceManager.getString(R.string.common_error_network), exception)
        }

        fun unexpectedError(exception: Throwable): BaseException {
            return BaseException(Kind.UNEXPECTED, exception.message ?: "", exception)
        }
    }
}