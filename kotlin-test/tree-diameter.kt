package treediameter

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TreeDiameterTest {
    @Test
    fun standardExamples() {
        assertEquals(4, Solution().treeDiameter(arrayOf(
            intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3),
            intArrayOf(1, 4), intArrayOf(2, 5), intArrayOf(2, 6))))
        assertEquals(2, Solution().treeDiameter(arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(1, 3))))
    }

    @Test
    fun singleNodeAndSingleEdge() {
        assertEquals(0, Solution().treeDiameter(arrayOf()))
        assertEquals(1, Solution().treeDiameter(arrayOf(intArrayOf(0, 1))))
    }

    @Test
    fun longPath() {
        assertEquals(5, Solution().treeDiameter(arrayOf(
            intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4), intArrayOf(4, 5))))
    }
}
