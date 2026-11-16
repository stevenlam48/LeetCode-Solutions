package numberofblackblocks

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class NumberOfBlackBlocksTest {
    @Test
    fun example1() {
        val coordinates = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(1, 2),
            intArrayOf(2, 1),
        )
        assertArrayEquals(longArrayOf(0, 0, 3, 1, 0), Solution().countBlackBlocks(3, 3, coordinates))
    }

    @Test
    fun example2() {
        val coordinates = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 1),
            intArrayOf(0, 2),
        )
        assertArrayEquals(longArrayOf(0, 2, 2, 0, 0), Solution().countBlackBlocks(3, 3, coordinates))
    }

    @Test
    fun fullyBlackSingleBlock() {
        val coordinates = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(1, 1),
        )
        assertArrayEquals(longArrayOf(0, 0, 0, 0, 1), Solution().countBlackBlocks(2, 2, coordinates))
    }

    @Test
    fun singleCell() {
        val coordinates = arrayOf(intArrayOf(0, 0))
        assertArrayEquals(longArrayOf(0, 1, 0, 0, 0), Solution().countBlackBlocks(2, 2, coordinates))
    }

    @Test
    fun wideGrid() {
        val coordinates = arrayOf(intArrayOf(0, 0))
        assertArrayEquals(longArrayOf(5, 1, 0, 0, 0), Solution().countBlackBlocks(3, 4, coordinates))
    }
}
