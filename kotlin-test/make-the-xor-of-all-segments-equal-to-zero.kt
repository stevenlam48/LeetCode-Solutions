package makethexorofallsegmentsequaltozero

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MakeTheXorOfAllSegmentsEqualToZeroTest {
    @Test
    fun testExample1() {
        assertEquals(3, Solution().minChanges(intArrayOf(1, 2, 0, 3, 0), 1))
    }

    @Test
    fun testSingleZero() {
        assertEquals(0, Solution().minChanges(intArrayOf(0), 1))
    }

    @Test
    fun testAlreadyZeroXor() {
        assertEquals(0, Solution().minChanges(intArrayOf(1, 2, 3), 3))
    }

    @Test
    fun testOneChangeNeeded() {
        assertEquals(1, Solution().minChanges(intArrayOf(1, 2, 4), 3))
    }

    @Test
    fun testTwoColumns() {
        assertEquals(4, Solution().minChanges(intArrayOf(1, 2, 4, 1, 2, 4), 2))
    }
}
