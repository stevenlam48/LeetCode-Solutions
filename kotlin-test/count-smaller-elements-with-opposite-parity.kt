package countsmallerelementswithoppositeparity

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class CountSmallerElementsWithOppositeParityTest {
    private val solution = Solution()

    @Test
    fun mixedParities() {
        assertArrayEquals(
            intArrayOf(0, 2, 0, 0),
            solution.countSmallerOppositeParity(intArrayOf(2, 8, 3, 5))
        )
    }

    @Test
    fun largerValuesAreIgnored() {
        assertArrayEquals(
            intArrayOf(0, 0, 0, 0),
            solution.countSmallerOppositeParity(intArrayOf(1, 2, 3, 4))
        )
    }

    @Test
    fun earlierOddValue() {
        assertArrayEquals(
            intArrayOf(1, 0, 0, 0),
            solution.countSmallerOppositeParity(intArrayOf(4, 1, 6, 2))
        )
    }

    @Test
    fun allRightSmallerValuesAreCounted() {
        assertArrayEquals(
            intArrayOf(2, 0, 0),
            solution.countSmallerOppositeParity(intArrayOf(2, 1, 1))
        )
    }
}
