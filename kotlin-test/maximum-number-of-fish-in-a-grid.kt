package maximumnumberoffishinagrid

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNumberOfFishInAGridTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertEquals(
            7,
            solution.findMaxFish(
                arrayOf(
                    intArrayOf(0, 2, 1, 0),
                    intArrayOf(4, 0, 0, 3),
                    intArrayOf(1, 0, 0, 4),
                    intArrayOf(0, 3, 0, 0)
                )
            )
        )
    }

    @Test
    fun exampleTwo() {
        assertEquals(
            1,
            solution.findMaxFish(
                arrayOf(
                    intArrayOf(1, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 0),
                    intArrayOf(0, 0, 0, 1)
                )
            )
        )
    }

    @Test
    fun noFish() {
        assertEquals(0, solution.findMaxFish(arrayOf(intArrayOf(0))))
    }

    @Test
    fun singleFish() {
        assertEquals(5, solution.findMaxFish(arrayOf(intArrayOf(5))))
    }

    @Test
    fun connectedBlock() {
        assertEquals(
            4,
            solution.findMaxFish(
                arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))
            )
        )
    }
}
