package numberofrecentcalls

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NumberOfRecentCallsTest {
    @Test
    fun testExample() {
        val counter = RecentCounter()
        assertEquals(1, counter.ping(1))
        assertEquals(2, counter.ping(100))
        assertEquals(3, counter.ping(3001))
        assertEquals(3, counter.ping(3002))
    }

    @Test
    fun testBoundary() {
        val counter = RecentCounter()
        assertEquals(1, counter.ping(0))
        assertEquals(2, counter.ping(3000))
        assertEquals(1, counter.ping(6001))
    }

    @Test
    fun testSinglePing() {
        val counter = RecentCounter()
        assertEquals(1, counter.ping(1000))
    }
}
