package maximumpointstouristcanearn

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MaximumPointsTouristCanEarnTest {
    @Test
    fun oneDay() {
        val stay = arrayOf(intArrayOf(2, 3))
        val travel = arrayOf(intArrayOf(0, 2), intArrayOf(1, 0))
        assertEquals(3, Solution().maxScore(2, 1, stay, travel))
    }

    @Test
    fun twoDays() {
        val stay = arrayOf(intArrayOf(1, 2), intArrayOf(3, 1))
        val travel = arrayOf(intArrayOf(0, 3), intArrayOf(2, 0))
        assertEquals(5, Solution().maxScore(2, 2, stay, travel))
    }

    @Test
    fun oneCityCanUseTravelScore() {
        val stay = arrayOf(intArrayOf(4), intArrayOf(5), intArrayOf(6))
        val travel = arrayOf(intArrayOf(10))
        assertEquals(30, Solution().maxScore(1, 3, stay, travel))
    }

    @Test
    fun zeroDays() {
        assertEquals(0, Solution().maxScore(2, 0, emptyArray(), arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))))
    }
}
