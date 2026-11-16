package maximumvalueafterinsertion

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumValueAfterInsertionTest {
    @Test
    fun examples() {
        assertEquals("999", Solution().maxValue("99", 9))
        assertEquals("-123", Solution().maxValue("-13", 2))
    }

    @Test
    fun insertAtBeginningOrEnd() {
        assertEquals("213", Solution().maxValue("13", 2))
        assertEquals("-999", Solution().maxValue("-99", 9))
    }

    @Test
    fun insertBetweenDigits() {
        assertEquals("743", Solution().maxValue("73", 4))
        assertEquals("500", Solution().maxValue("50", 0))
    }
}
