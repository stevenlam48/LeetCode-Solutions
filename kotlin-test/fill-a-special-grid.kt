package fillaspecialgrid

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FillASpecialGridTest {
    @Test
    fun zeroProducesSingleZeroCell() {
        assertArrayEquals(arrayOf(intArrayOf(0)), Solution().specialGrid(0))
    }

    @Test
    fun oneProducesTwoByTwoSpiral() {
        val expected = arrayOf(
            intArrayOf(3, 0),
            intArrayOf(2, 1)
        )
        assertArrayEquals(expected, Solution().specialGrid(1))
    }

    @Test
    fun twoProducesFourByFourSpiral() {
        val expected = arrayOf(
            intArrayOf(15, 12, 3, 0),
            intArrayOf(14, 13, 2, 1),
            intArrayOf(11, 8, 7, 4),
            intArrayOf(10, 9, 6, 5)
        )
        assertArrayEquals(expected, Solution().specialGrid(2))
    }

    @Test
    fun threeProducesEightByEightSpiral() {
        val expected = arrayOf(
            intArrayOf(63, 60, 51, 48, 15, 12, 3, 0),
            intArrayOf(62, 61, 50, 49, 14, 13, 2, 1),
            intArrayOf(59, 56, 55, 52, 11, 8, 7, 4),
            intArrayOf(58, 57, 54, 53, 10, 9, 6, 5),
            intArrayOf(47, 44, 35, 32, 31, 28, 19, 16),
            intArrayOf(46, 45, 34, 33, 30, 29, 18, 17),
            intArrayOf(43, 40, 39, 36, 27, 24, 23, 20),
            intArrayOf(42, 41, 38, 37, 26, 25, 22, 21)
        )
        assertArrayEquals(expected, Solution().specialGrid(3))
    }
}
