package countnumberofmaximumbitwiseorsubsets

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountNumberOfMaximumBitwiseOrSubsetsTest {
    @Test
    fun twoElementExample() {
        assertEquals(2, Solution().countMaxOrSubsets(intArrayOf(3, 1)))
    }

    @Test
    fun everyNonEmptyDuplicateSubsetHasMaximumOr() {
        assertEquals(7, Solution().countMaxOrSubsets(intArrayOf(2, 2, 2)))
    }

    @Test
    fun severalWaysToReachMaximumOr() {
        assertEquals(6, Solution().countMaxOrSubsets(intArrayOf(3, 2, 1, 5)))
    }

    @Test
    fun disjointBitsRequireTheFullArray() {
        assertEquals(1, Solution().countMaxOrSubsets(intArrayOf(1, 2, 4)))
    }

    @Test
    fun singleElementHasOneSubset() {
        assertEquals(1, Solution().countMaxOrSubsets(intArrayOf(7)))
    }
}
