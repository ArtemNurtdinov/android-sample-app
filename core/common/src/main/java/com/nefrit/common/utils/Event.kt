package com.nefrit.common.utils

import androidx.lifecycle.Observer
import kotlinx.coroutines.flow.FlowCollector

open class Event<out T>(private val content: T) {

    var hasBeenHandled = false
        private set

    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    fun peekContent(): T = content
}

class SimpleEvent

class EventObserver<T>(
    private val onEventUnhandledContent: (T) -> Unit
) : Observer<Event<T>> {

    override fun onChanged(event: Event<T>?) {
        event?.getContentIfNotHandled()?.let(onEventUnhandledContent)
    }
}

class EventCollector<T>(
    private val onEventUnhandledContent: (T) -> Unit
): FlowCollector<Event<T>> {

    override suspend fun emit(event: Event<T>) {
        event.getContentIfNotHandled()?.let(onEventUnhandledContent)
    }
}