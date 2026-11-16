package maximizecyclicpartitionscore

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeCyclicPartitionScoreTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(3L, solution.maximumScore(intArrayOf(1, 2, 3, 3), 2))
    }

    @Test
    fun testExample2() {
        assertEquals(2L, solution.maximumScore(intArrayOf(1, 2, 3, 3), 1))
    }

    @Test
    fun testExample3() {
        assertEquals(3L, solution.maximumScore(intArrayOf(1, 2, 3, 3), 4))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0L, solution.maximumScore(intArrayOf(5), 1))
    }

    @Test
    fun testThreeElements() {
        assertEquals(4L, solution.maximumScore(intArrayOf(1, 5, 1), 2))
    }

    @Test
    fun testAllEqual() {
        assertEquals(0L, solution.maximumScore(intArrayOf(1, 1, 1), 2))
    }
}
