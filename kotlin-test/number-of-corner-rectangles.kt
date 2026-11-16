package numberofcornerrectangles

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class NumberOfCornerRectanglesTest {
    @Test
    fun example1() {
        assertEquals(
            1,
            Solution().countCornerRectangles(
                arrayOf(
                    intArrayOf(1, 0, 0, 1, 0),
                    intArrayOf(0, 0, 1, 0, 1),
                    intArrayOf(0, 0, 0, 1, 0),
                    intArrayOf(1, 0, 1, 0, 1)
                )
            )
        )
    }

    @Test
    fun example2() {
        assertEquals(
            9,
            Solution().countCornerRectangles(
                arrayOf(
                    intArrayOf(1, 1, 1),
                    intArrayOf(1, 1, 1),
                    intArrayOf(1, 1, 1)
                )
            )
        )
    }

    @Test
    fun singleRowCannotFormRectangle() {
        assertEquals(
            0,
            Solution().countCornerRectangles(arrayOf(intArrayOf(1, 1, 1, 1)))
        )
    }

    @Test
    fun emptyRowsAreIgnored() {
        assertEquals(
            1,
            Solution().countCornerRectangles(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(0, 0),
                    intArrayOf(1, 1)
                )
            )
        )
    }

    @Test
    fun noSharedColumnPair() {
        assertEquals(
            0,
            Solution().countCornerRectangles(
                arrayOf(
                    intArrayOf(1, 1, 0, 0),
                    intArrayOf(0, 0, 1, 1)
                )
            )
        )
    }
}
