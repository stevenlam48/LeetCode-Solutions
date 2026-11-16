package sellingpiecesofwood

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SellingPiecesOfWoodTest {
    @Test
    fun oneByOne() {
        assertEquals(1L, Solution().sellingWood(1, 1, arrayOf(intArrayOf(1, 1, 1))))
    }

    @Test
    fun cuttingIntoOnes() {
        assertEquals(4L, Solution().sellingWood(2, 2, arrayOf(intArrayOf(1, 1, 1))))
    }

    @Test
    fun wholePieceIsBetterThanCuts() {
        assertEquals(10L, Solution().sellingWood(2, 2, arrayOf(intArrayOf(2, 2, 10))))
    }

    @Test
    fun dimensionPriceEnablesHorizontalCuts() {
        assertEquals(6L, Solution().sellingWood(2, 2, arrayOf(intArrayOf(1, 2, 3))))
    }

    @Test
    fun pickBestBetweenWholeAndDimension() {
        assertEquals(6L, Solution().sellingWood(2, 2, arrayOf(intArrayOf(1, 2, 3), intArrayOf(2, 2, 5))))
    }

    @Test
    fun threeByThreeOnes() {
        assertEquals(9L, Solution().sellingWood(3, 3, arrayOf(intArrayOf(1, 1, 1))))
    }
}
