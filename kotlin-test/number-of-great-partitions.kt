package numberofgreatpartitions

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfGreatPartitionsTest {
    @Test
    fun testExample1() {
        assertEquals(6, Solution().countPartitions(intArrayOf(1, 2, 3, 4), 4))
    }

    @Test
    fun testExample2() {
        assertEquals(0, Solution().countPartitions(intArrayOf(3, 3, 3), 4))
    }

    @Test
    fun testTwoEqualElements() {
        assertEquals(2, Solution().countPartitions(intArrayOf(6, 6), 2))
    }

    @Test
    fun testTwoOnes() {
        assertEquals(2, Solution().countPartitions(intArrayOf(1, 1), 1))
    }

    @Test
    fun testTotalTooSmall() {
        assertEquals(0, Solution().countPartitions(intArrayOf(1, 2), 3))
    }
}
