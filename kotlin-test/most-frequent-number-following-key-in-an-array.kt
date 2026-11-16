package mostfrequentnumberfollowingkeyinanarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MostFrequentNumberFollowingKeyInAnArrayTest {
    private val solution = Solution()

    @Test
    fun findsMostFrequentFollower() {
        assertEquals(100, solution.mostFrequent(intArrayOf(1, 100, 200, 1, 100), 1))
    }

    @Test
    fun handlesKeyFollowingItself() {
        assertEquals(2, solution.mostFrequent(intArrayOf(2, 2, 2, 2, 3), 2))
    }

    @Test
    fun keepsFirstFollowerWhenFrequenciesTie() {
        assertEquals(2, solution.mostFrequent(intArrayOf(1, 2, 1, 3, 1, 2), 1))
    }

    @Test
    fun returnsZeroWhenKeyHasNoFollower() {
        assertEquals(0, solution.mostFrequent(intArrayOf(1, 2, 3), 3))
    }
}
