package nextclosesttime

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NextClosestTimeTest {
    @Test
    fun `reuses displayed digits for next time`() {
        assertEquals("19:39", Solution().nextClosestTime("19:34"))
    }

    @Test
    fun `wraps around midnight`() {
        assertEquals("22:22", Solution().nextClosestTime("23:59"))
    }

    @Test
    fun `advances just one minute`() {
        assertEquals("01:33", Solution().nextClosestTime("01:32"))
    }

    @Test
    fun `returns same time after full day when no closer time exists`() {
        assertEquals("11:11", Solution().nextClosestTime("11:11"))
    }
}
