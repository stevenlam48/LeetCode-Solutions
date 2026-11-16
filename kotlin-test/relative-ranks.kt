package relativeranks

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class RelativeRanksTest {
    @Test
    fun descendingScores() {
        assertArrayEquals(
            arrayOf("Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"),
            Solution().findRelativeRanks(intArrayOf(5, 4, 3, 2, 1))
        )
    }

    @Test
    fun mixedScores() {
        assertArrayEquals(
            arrayOf("Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"),
            Solution().findRelativeRanks(intArrayOf(10, 3, 8, 9, 4))
        )
    }

    @Test
    fun singleScore() {
        assertArrayEquals(arrayOf("Gold Medal"), Solution().findRelativeRanks(intArrayOf(7)))
    }
}
