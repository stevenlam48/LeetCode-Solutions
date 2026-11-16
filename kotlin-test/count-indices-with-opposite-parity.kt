package countindiceswithoppositeparity

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class CountIndicesWithOppositeParityTest {
    private val solution = Solution()

    @Test
    fun countsOnlyLaterIndices() {
        assertArrayEquals(intArrayOf(2, 1, 1, 0), solution.countOppositeParity(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun sameParityProducesZeroes() {
        assertArrayEquals(intArrayOf(0, 0, 0), solution.countOppositeParity(intArrayOf(2, 4, 6)))
    }

    @Test
    fun handlesEmptyInput() {
        assertArrayEquals(IntArray(0), solution.countOppositeParity(IntArray(0)))
    }
}
