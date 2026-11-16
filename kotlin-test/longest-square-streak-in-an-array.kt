package longestsquarestreakinanarray

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LongestSquareStreakInAnArrayTest {
    @Test
    fun standardExample() {
        assertEquals(3, Solution().longestSquareStreak(intArrayOf(4, 3, 6, 16, 8, 2)))
    }

    @Test
    fun fullSquareChain() {
        assertEquals(4, Solution().longestSquareStreak(intArrayOf(2, 4, 16, 256)))
    }

    @Test
    fun noSquarePair() {
        assertEquals(-1, Solution().longestSquareStreak(intArrayOf(3, 5, 7)))
    }

    @Test
    fun duplicatesDoNotExtendAChain() {
        assertEquals(2, Solution().longestSquareStreak(intArrayOf(2, 2, 4)))
    }
}
