package platesbetweencandles

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class PlatesBetweenCandlesTest {
    @Test
    fun standardExample() {
        assertArrayEquals(
            intArrayOf(2, 3),
            Solution().platesBetweenCandles(
                "**|**|***|",
                arrayOf(intArrayOf(2, 5), intArrayOf(5, 9))
            )
        )
    }

    @Test
    fun queryWithoutEnclosingCandles() {
        assertArrayEquals(
            intArrayOf(0),
            Solution().platesBetweenCandles("***|***", arrayOf(intArrayOf(0, 2)))
        )
    }

    @Test
    fun adjacentCandles() {
        assertArrayEquals(
            intArrayOf(0),
            Solution().platesBetweenCandles("**|**", arrayOf(intArrayOf(0, 3)))
        )
    }

    @Test
    fun plateOutsideCandles() {
        assertArrayEquals(
            intArrayOf(0, 3),
            Solution().platesBetweenCandles(
                "**|***|*",
                arrayOf(intArrayOf(0, 1), intArrayOf(0, 6))
            )
        )
    }
}
