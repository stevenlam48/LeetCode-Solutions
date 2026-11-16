package maximumwhitetilescoveredbyacarpet

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumWhiteTilesCoveredByACarpetTest {
    private val solution = Solution()

    @Test
    fun carpetSpansTwoAdjacentTiles() {
        val tiles = arrayOf(
            intArrayOf(1, 5), intArrayOf(10, 11), intArrayOf(12, 18),
            intArrayOf(20, 25), intArrayOf(30, 32)
        )
        assertEquals(9, solution.maximumWhiteTiles(tiles, 10))
    }

    @Test
    fun carpetInsideOneLongTile() {
        assertEquals(5, solution.maximumWhiteTiles(arrayOf(intArrayOf(1, 10)), 5))
    }

    @Test
    fun carpetShorterThanOneTile() {
        assertEquals(3, solution.maximumWhiteTiles(arrayOf(intArrayOf(1, 5)), 3))
    }

    @Test
    fun separateSingleTiles() {
        val tiles = arrayOf(intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(3, 3))
        assertEquals(2, solution.maximumWhiteTiles(tiles, 2))
    }

    @Test
    fun singleTileExactlyCarpetLength() {
        assertEquals(1, solution.maximumWhiteTiles(arrayOf(intArrayOf(1, 1)), 1))
    }
}
