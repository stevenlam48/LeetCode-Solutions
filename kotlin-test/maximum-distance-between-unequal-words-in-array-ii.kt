package maximumdistancebetweenunequalwordsinarrayii
// Time:  O(n * l)
// Space: O(1)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumDistanceBetweenUnequalWordsInArrayIiTest {
    private val solution = Solution()

    @Test
    fun unequalEndpointsGiveFullLength() {
        assertEquals(3, solution.maxDistance(listOf("hello", "world", "leetcode")))
    }

    @Test
    fun repeatedEndpointsAllowInnerPair() {
        assertEquals(4, solution.maxDistance(listOf("a", "a", "a", "b", "a")))
    }

    @Test
    fun equalMiddleWordOnlyShortensByOne() {
        assertEquals(2, solution.maxDistance(listOf("a", "b", "a")))
    }

    @Test
    fun allEqualWordsHaveNoValidPair() {
        assertEquals(0, solution.maxDistance(listOf("same", "same", "same")))
    }
}
