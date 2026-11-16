package dietplanperformance

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DietPlanPerformanceTest {
    @Test
    fun testExample1() {
        assertEquals(0, Solution().dietPlanPerformance(intArrayOf(1, 2, 3, 4, 5), 1, 3, 3))
    }

    @Test
    fun testExample2() {
        assertEquals(1, Solution().dietPlanPerformance(intArrayOf(3, 2), 2, 0, 1))
    }

    @Test
    fun testExample3() {
        assertEquals(0, Solution().dietPlanPerformance(intArrayOf(6, 5, 0, 0), 2, 1, 5))
    }

    @Test
    fun testSingleElement() {
        assertEquals(1, Solution().dietPlanPerformance(intArrayOf(10), 1, 0, 5))
        assertEquals(-1, Solution().dietPlanPerformance(intArrayOf(1), 1, 5, 10))
        assertEquals(0, Solution().dietPlanPerformance(intArrayOf(5), 1, 5, 5))
    }

    @Test
    fun testAllWindows() {
        assertEquals(3, Solution().dietPlanPerformance(intArrayOf(1, 1, 1, 1), 2, 0, 1))
    }
}
