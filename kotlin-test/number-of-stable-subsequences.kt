package numberofstablesubsequences

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NumberOfStableSubsequencesTest {
    @Test
    fun testSingleElement() {
        assertEquals(1, Solution().countStableSubsequences(intArrayOf(1)))
        assertEquals(1, Solution().countStableSubsequences(intArrayOf(2)))
    }

    @Test
    fun testTwoElements() {
        assertEquals(3, Solution().countStableSubsequences(intArrayOf(1, 2)))
    }

    @Test
    fun testThreeElements() {
        assertEquals(7, Solution().countStableSubsequences(intArrayOf(1, 2, 3)))
    }

    @Test
    fun testAllEven() {
        assertEquals(6, Solution().countStableSubsequences(intArrayOf(2, 2, 2)))
    }

    @Test
    fun testMixed() {
        assertEquals(15, Solution().countStableSubsequences(intArrayOf(1, 1, 2, 2)))
        assertEquals(15, Solution().countStableSubsequences(intArrayOf(1, 2, 1, 2)))
    }
}
