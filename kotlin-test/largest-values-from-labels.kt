package largestvaluesfromlabels

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LargestValuesFromLabelsTest {
    private val solution = Solution()

    @Test
    fun selectsValuesWithOneUsePerLabel() {
        assertEquals(
            9,
            solution.largestValsFromLabels(
                intArrayOf(5, 4, 3, 2, 1),
                intArrayOf(1, 1, 2, 2, 3),
                3,
                1
            )
        )
    }

    @Test
    fun allowsTwoUsesPerLabel() {
        assertEquals(
            12,
            solution.largestValsFromLabels(
                intArrayOf(5, 4, 3, 2, 1),
                intArrayOf(1, 1, 2, 2, 3),
                3,
                2
            )
        )
    }

    @Test
    fun stopsWhenNoMoreValuesCanBeSelected() {
        assertEquals(
            16,
            solution.largestValsFromLabels(
                intArrayOf(9, 8, 8, 7, 6),
                intArrayOf(0, 0, 0, 1, 1),
                3,
                1
            )
        )
    }

    @Test
    fun returnsZeroWhenNothingIsWanted() {
        assertEquals(0, solution.largestValsFromLabels(intArrayOf(), intArrayOf(), 0, 1))
    }
}
