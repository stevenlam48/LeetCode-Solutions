package countnumberofbalancedpermutations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountNumberOfBalancedPermutationsTest {
    @Test
    fun exampleWithTwoBalancedPermutations() {
        assertEquals(2, Solution().countBalancedPermutations("123"))
    }

    @Test
    fun exampleWithDuplicateDigit() {
        assertEquals(1, Solution().countBalancedPermutations("112"))
    }

    @Test
    fun oddDigitSumHasNoBalancedPermutation() {
        assertEquals(0, Solution().countBalancedPermutations("12345"))
    }

    @Test
    fun singleZeroIsBalanced() {
        assertEquals(1, Solution().countBalancedPermutations("0"))
    }

    @Test
    fun duplicatedPairsHaveFourBalancedPermutations() {
        assertEquals(4, Solution().countBalancedPermutations("1122"))
    }
}
