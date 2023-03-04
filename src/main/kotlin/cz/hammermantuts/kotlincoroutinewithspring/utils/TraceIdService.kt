package cz.hammermantuts.kotlincoroutinewithspring.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.slf4j.MDCContext
import kotlinx.coroutines.withContext
import org.slf4j.MDC
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

object TraceIdService {
    private const val TraceIdKey: String = "traceId"

    suspend fun <T> withTraceId(traceId: String, block: suspend CoroutineScope.() -> T): T =
        try {
            MDC.put(TraceIdKey, traceId)
            withContext(MDCContext().plus(TraceIdContext(traceId)), block)
        } finally {
            MDC.clear()
        }

    data class TraceIdContext(val traceId: String) : AbstractCoroutineContextElement(Key) {
        companion object Key : CoroutineContext.Key<TraceIdContext>
    }
}