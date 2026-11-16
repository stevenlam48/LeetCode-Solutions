package numberofpairsofinterchangeablerectangles

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfPairsOfInterchangeableRectanglesTest {
    @Test
    fun allRectanglesShareOneRatio() {
        val rectangles = arrayOf(
            intArrayOf(4, 8),
            intArrayOf(3, 6),
            intArrayOf(10, 20),
            intArrayOf(15, 30)
        )
        assertEquals(6L, Solution().interchangeableRectangles(rectangles))
    }

    @Test
    fun distinctReducedRatiosDoNotPair() {
        val rectangles = arrayOf(
            intArrayOf(4, 5),
            intArrayOf(7, 8),
            intArrayOf(5, 4),
            intArrayOf(6, 10)
        )
        assertEquals(0L, Solution().interchangeableRectangles(rectangles))
    }

    @Test
    fun combinesPairsFromSeparateRatioGroups() {
        val rectangles = arrayOf(
            intArrayOf(2, 4),
            intArrayOf(4, 8),
            intArrayOf(6, 12),
            intArrayOf(1, 3),
            intArrayOf(2, 6)
        )
        assertEquals(4L, Solution().interchangeableRectangles(rectangles))
    }

    @Test
    fun emptyAndSingletonInputsHaveNoPairs() {
        assertEquals(0L, Solution().interchangeableRectangles(arrayOf()))
        assertEquals(0L, Solution().interchangeableRectangles(arrayOf(intArrayOf(7, 14))))
    }
}
