package finishtimeoftasksii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FinishTimeOfTasksIITest {
    @Test
    fun singleTask() {
        assertEquals(7L, Solution().finishTime(1, arrayOf<IntArray>(), intArrayOf(7)))
    }

    @Test
    fun singleEdge() {
        assertEquals(3L, Solution().finishTime(2, arrayOf(intArrayOf(0, 1)), intArrayOf(1, 2)))
    }

    @Test
    fun pathOfThree() {
        assertEquals(
            2L,
            Solution().finishTime(3, arrayOf(intArrayOf(0, 1), intArrayOf(1, 2)), intArrayOf(1, 1, 1))
        )
    }

    @Test
    fun starOfFour() {
        assertEquals(
            7L,
            Solution().finishTime(
                4,
                arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3)),
                intArrayOf(1, 2, 3, 4)
            )
        )
    }
}
