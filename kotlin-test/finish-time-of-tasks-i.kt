package finishtimeoftasksi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FinishTimeOfTasksITest {
    @Test
    fun singleTask() {
        assertEquals(5L, Solution().finishTime(1, arrayOf<IntArray>(), intArrayOf(5)))
    }

    @Test
    fun singleChild() {
        assertEquals(3L, Solution().finishTime(2, arrayOf(intArrayOf(0, 1)), intArrayOf(1, 2)))
    }

    @Test
    fun twoChildren() {
        assertEquals(
            9L,
            Solution().finishTime(3, arrayOf(intArrayOf(0, 1), intArrayOf(0, 2)), intArrayOf(1, 2, 5))
        )
    }

    @Test
    fun deeperTree() {
        assertEquals(
            8L,
            Solution().finishTime(
                4,
                arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(1, 3)),
                intArrayOf(1, 2, 3, 4)
            )
        )
    }
}
