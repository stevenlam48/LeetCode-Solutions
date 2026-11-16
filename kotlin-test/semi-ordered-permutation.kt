package semiorderedpermutation

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SemiOrderedPermutationTest {
    @Test
    fun exampleTwoOneFourThree() {
        assertEquals(2, Solution().semiOrderedPermutation(intArrayOf(2, 1, 4, 3)))
    }

    @Test
    fun exampleTwoOneThree() {
        assertEquals(1, Solution().semiOrderedPermutation(intArrayOf(2, 1, 3)))
    }

    @Test
    fun alreadySemiOrdered() {
        assertEquals(0, Solution().semiOrderedPermutation(intArrayOf(1, 3, 2, 4)))
    }

    @Test
    fun reversedTriple() {
        assertEquals(3, Solution().semiOrderedPermutation(intArrayOf(3, 2, 1)))
    }

    @Test
    fun sortedPair() {
        assertEquals(0, Solution().semiOrderedPermutation(intArrayOf(1, 2)))
    }

    @Test
    fun reversedPair() {
        assertEquals(1, Solution().semiOrderedPermutation(intArrayOf(2, 1)))
    }
}
