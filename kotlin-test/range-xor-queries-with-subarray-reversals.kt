package rangexorquerieswithsubarrayreversals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class RangeXorQueriesWithSubarrayReversalsTest {
    @Test
    fun mixedUpdatesQueriesAndReversals() {
        val result = Solution().getResults(
            intArrayOf(1, 2, 3, 4, 5),
            arrayOf(
                intArrayOf(2, 0, 4),
                intArrayOf(2, 1, 3),
                intArrayOf(3, 1, 3),
                intArrayOf(2, 0, 2),
                intArrayOf(1, 2, 7),
                intArrayOf(2, 1, 4),
                intArrayOf(3, 0, 4),
                intArrayOf(2, 2, 4)
            )
        )
        assertArrayEquals(intArrayOf(1, 5, 6, 4, 2), result)
    }

    @Test
    fun reversingTwiceRestoresOrder() {
        val result = Solution().getResults(
            intArrayOf(8, 3, 6, 1),
            arrayOf(
                intArrayOf(3, 0, 3),
                intArrayOf(3, 0, 3),
                intArrayOf(2, 0, 3),
                intArrayOf(3, 1, 2),
                intArrayOf(2, 0, 1),
                intArrayOf(2, 2, 3)
            )
        )
        assertArrayEquals(intArrayOf(12, 14, 2), result)
    }

    @Test
    fun singleElementUpdates() {
        val result = Solution().getResults(
            intArrayOf(0),
            arrayOf(
                intArrayOf(2, 0, 0),
                intArrayOf(1, 0, -1),
                intArrayOf(2, 0, 0),
                intArrayOf(3, 0, 0),
                intArrayOf(2, 0, 0)
            )
        )
        assertArrayEquals(intArrayOf(0, -1, -1), result)
    }
}
