package maximumnumberofones

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MaximumNumberOfOnesTest {
    private val solution = Solution()

    @Test
    fun oneOnePerSubsquare() {
        assertEquals(4, solution.maximumNumberOfOnes(3, 3, 2, 1))
    }

    @Test
    fun twoOnesPerSubsquare() {
        assertEquals(6, solution.maximumNumberOfOnes(3, 3, 2, 2))
    }

    @Test
    fun fillEveryCell() {
        assertEquals(9, solution.maximumNumberOfOnes(3, 3, 2, 4))
    }

    @Test
    fun singleSubsquare() {
        assertEquals(1, solution.maximumNumberOfOnes(2, 2, 2, 1))
    }

    @Test
    fun rectangularInputRequiresSwap() {
        assertEquals(2, solution.maximumNumberOfOnes(2, 3, 2, 1))
    }

    @Test
    fun zeroOnesAllowed() {
        assertEquals(0, solution.maximumNumberOfOnes(5, 4, 2, 0))
    }
}
