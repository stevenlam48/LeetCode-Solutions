package findthemaximumfactorscoreofarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheMaximumFactorScoreOfArrayTest {
    @Test
    fun removingFirstElementImprovesScore() {
        assertEquals(64L, Solution().maxScore(intArrayOf(2, 4, 8, 16)))
    }

    @Test
    fun coprimeArray() {
        assertEquals(60L, Solution().maxScore(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun bestRemovalIsFirst() {
        assertEquals(150L, Solution().maxScore(intArrayOf(6, 10, 15)))
    }

    @Test
    fun keepingWholeArrayIsBest() {
        assertEquals(432L, Solution().maxScore(intArrayOf(12, 18, 24)))
    }

    @Test
    fun singleElement() {
        assertEquals(49L, Solution().maxScore(intArrayOf(7)))
    }
}
