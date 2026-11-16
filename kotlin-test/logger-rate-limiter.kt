package loggerratelimiter

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LoggerRateLimiterTest {
    @Test
    fun leetCodeOperationSequence() {
        val logger = Logger()
        assertTrue(logger.shouldPrintMessage(1, "foo"))
        assertTrue(logger.shouldPrintMessage(2, "bar"))
        assertFalse(logger.shouldPrintMessage(3, "foo"))
        assertFalse(logger.shouldPrintMessage(8, "foo"))
        assertFalse(logger.shouldPrintMessage(10, "foo"))
        assertTrue(logger.shouldPrintMessage(11, "foo"))
    }

    @Test
    fun oldMessagesExpireInQueueOrder() {
        val logger = Logger()
        assertTrue(logger.shouldPrintMessage(1, "a"))
        assertTrue(logger.shouldPrintMessage(2, "b"))
        assertFalse(logger.shouldPrintMessage(10, "a"))
        assertTrue(logger.shouldPrintMessage(11, "a"))
        assertTrue(logger.shouldPrintMessage(12, "b"))
    }

    @Test
    fun messagesAreLimitedIndependently() {
        val logger = Logger()
        assertTrue(logger.shouldPrintMessage(0, "foo"))
        assertTrue(logger.shouldPrintMessage(0, "bar"))
        assertFalse(logger.shouldPrintMessage(0, "foo"))
        assertFalse(logger.shouldPrintMessage(9, "bar"))
    }

    @Test
    fun messageExpiresExactlyTenSecondsLater() {
        val logger = Logger()
        assertTrue(logger.shouldPrintMessage(5, "message"))
        assertFalse(logger.shouldPrintMessage(14, "message"))
        assertTrue(logger.shouldPrintMessage(15, "message"))
    }
}
