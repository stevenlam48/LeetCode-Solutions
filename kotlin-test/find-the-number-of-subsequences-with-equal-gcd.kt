package findthenumberofsubsequenceswithequalgcd

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheNumberOfSubsequencesWithEqualGcdTest {
    @Test
    fun leetCodeExample() {
        assertEquals(10, Solution().subsequencePairCount(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun singletonCannotPopulateBothSubsequences() {
        assertEquals(0, Solution().subsequencePairCount(intArrayOf(1)))
    }

    @Test
    fun twoEqualElementsCanBeExchanged() {
        assertEquals(2, Solution().subsequencePairCount(intArrayOf(1, 1)))
    }

    @Test
    fun valuesCanJoinEitherSubsequence() {
        assertEquals(12, Solution().subsequencePairCount(intArrayOf(1, 1, 1)))
    }

    @Test
    fun multiplesCanHaveTheSameGcd() {
        assertEquals(0, Solution().subsequencePairCount(intArrayOf(2, 4)))
    }
}
