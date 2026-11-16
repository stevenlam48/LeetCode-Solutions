package firstcompletelypaintedroworcolumn

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FirstCompletelyPaintedRowOrColumnTest {
    @Test
    fun example1() {
        assertEquals(
            2,
            Solution().firstCompleteIndex(
                intArrayOf(1, 3, 4, 2),
                arrayOf(intArrayOf(1, 4), intArrayOf(2, 3))
            )
        )
    }

    @Test
    fun example2() {
        assertEquals(
            3,
            Solution().firstCompleteIndex(
                intArrayOf(2, 8, 7, 4, 1, 3, 5, 6, 9),
                arrayOf(intArrayOf(3, 2, 5), intArrayOf(1, 4, 6), intArrayOf(8, 7, 9))
            )
        )
    }

    @Test
    fun example3() {
        assertEquals(
            1,
            Solution().firstCompleteIndex(
                intArrayOf(1, 4, 5, 2, 6, 3),
                arrayOf(intArrayOf(4, 3, 5), intArrayOf(1, 2, 6))
            )
        )
    }

    @Test
    fun singleCell() {
        assertEquals(0, Solution().firstCompleteIndex(intArrayOf(1), arrayOf(intArrayOf(1))))
    }

    @Test
    fun singleRow() {
        assertEquals(
            0,
            Solution().firstCompleteIndex(intArrayOf(3, 1, 2), arrayOf(intArrayOf(1, 2, 3)))
        )
    }
}
