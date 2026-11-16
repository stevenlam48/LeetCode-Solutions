package bagoftokens

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BagOfTokensTest {
    private val solution = Solution()

    @Test
    fun buysAndRedeemsForTwoPoints() {
        assertEquals(2, solution.bagOfTokensScore(intArrayOf(100, 200, 300, 400), 200))
    }

    @Test
    fun unaffordableSingleTokenWithoutPoints() {
        assertEquals(0, solution.bagOfTokensScore(intArrayOf(100), 50))
    }

    @Test
    fun oneAffordableTokenThenStops() {
        assertEquals(1, solution.bagOfTokensScore(intArrayOf(200, 100), 100))
    }

    @Test
    fun emptyTokens() {
        assertEquals(0, solution.bagOfTokensScore(intArrayOf(), 1000))
    }
}
