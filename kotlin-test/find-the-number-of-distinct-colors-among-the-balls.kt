package findthenumberofdistinctcolorsamongtheballs

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindTheNumberOfDistinctColorsAmongTheBallsTest {
    @Test
    fun example1() {
        assertArrayEquals(
            intArrayOf(1, 2, 2, 3),
            Solution().queryResults(
                4,
                arrayOf(
                    intArrayOf(1, 4), intArrayOf(2, 5),
                    intArrayOf(1, 3), intArrayOf(3, 4)
                )
            )
        )
    }

    @Test
    fun example2() {
        assertArrayEquals(
            intArrayOf(1, 2, 2, 3, 4),
            Solution().queryResults(
                4,
                arrayOf(
                    intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 2),
                    intArrayOf(3, 4), intArrayOf(4, 5)
                )
            )
        )
    }

    @Test
    fun singleQuery() {
        assertArrayEquals(
            intArrayOf(1),
            Solution().queryResults(1, arrayOf(intArrayOf(0, 1)))
        )
    }
}
