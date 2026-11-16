package maximumnumberofeatenapples

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNumberOfEatenApplesTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(
            7,
            solution.eatenApples(intArrayOf(1, 2, 3, 5, 2), intArrayOf(3, 2, 1, 4, 2))
        )
    }

    @Test
    fun exampleTwo() {
        assertEquals(
            5,
            solution.eatenApples(intArrayOf(3, 0, 0, 0, 0, 2), intArrayOf(3, 0, 0, 0, 0, 2))
        )
    }

    @Test
    fun singleApple() {
        assertEquals(1, solution.eatenApples(intArrayOf(1), intArrayOf(1)))
    }

    @Test
    fun noApples() {
        assertEquals(0, solution.eatenApples(intArrayOf(0), intArrayOf(0)))
    }

    @Test
    fun applesRotBeforeUse() {
        assertEquals(1, solution.eatenApples(intArrayOf(2, 0), intArrayOf(1, 1)))
    }

    @Test
    fun applesFromTwoBatches() {
        assertEquals(2, solution.eatenApples(intArrayOf(1, 1), intArrayOf(1, 1)))
    }
}
