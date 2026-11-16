package minimumscorebychangingtwoelements

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumScoreByChangingTwoElementsTest {
    @Test
    fun example1() {
        assertEquals(0, Solution().minimizeSum(intArrayOf(1, 4, 3)))
    }

    @Test
    fun example2() {
        assertEquals(3, Solution().minimizeSum(intArrayOf(1, 4, 7, 8, 5)))
    }

    @Test
    fun fourElements() {
        assertEquals(1, Solution().minimizeSum(intArrayOf(1, 4, 3, 5)))
    }

    @Test
    fun alreadyEqual() {
        assertEquals(0, Solution().minimizeSum(intArrayOf(2, 2, 2, 2)))
    }
}
