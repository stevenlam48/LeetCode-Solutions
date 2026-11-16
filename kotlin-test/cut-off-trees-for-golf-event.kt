package cutofftreesforgolfevent

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CutOffTreesForGolfEventTest {
    @Test
    fun example1() {
        val forest = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(0, 0, 4),
            intArrayOf(7, 6, 5)
        )
        assertEquals(6, Solution().cutOffTree(forest))
    }

    @Test
    fun example2() {
        val forest = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(0, 0, 0),
            intArrayOf(7, 6, 5)
        )
        assertEquals(-1, Solution().cutOffTree(forest))
    }

    @Test
    fun example3() {
        val forest = arrayOf(
            intArrayOf(2, 3, 4),
            intArrayOf(0, 0, 5),
            intArrayOf(8, 7, 6)
        )
        assertEquals(6, Solution().cutOffTree(forest))
    }

    @Test
    fun noTrees() {
        assertEquals(0, Solution().cutOffTree(arrayOf(intArrayOf(1))))
        assertEquals(0, Solution().cutOffTree(arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))))
    }

    @Test
    fun singleAdjacentTree() {
        assertEquals(1, Solution().cutOffTree(arrayOf(intArrayOf(1, 2))))
    }

    @Test
    fun unreachableTree() {
        val forest = arrayOf(
            intArrayOf(1, 0, 2)
        )
        assertEquals(-1, Solution().cutOffTree(forest))
    }
}
