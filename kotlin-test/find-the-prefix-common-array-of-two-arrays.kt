package findtheprefixcommonarrayoftwoarrays

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindThePrefixCommonArrayOfTwoArraysTest {
    private val solution = Solution()

    @Test
    fun sharedNumbersAppearAtDifferentPrefixes() {
        assertArrayEquals(
            intArrayOf(0, 2, 3, 4),
            solution.findThePrefixCommonArray(
                intArrayOf(1, 3, 2, 4),
                intArrayOf(3, 1, 2, 4)
            )
        )
    }

    @Test
    fun allNumbersBecomeCommonOnlyAtFinalPrefix() {
        assertArrayEquals(
            intArrayOf(0, 1, 3),
            solution.findThePrefixCommonArray(
                intArrayOf(2, 3, 1),
                intArrayOf(3, 1, 2)
            )
        )
    }

    @Test
    fun identicalArraysCountEachElementOnce() {
        assertArrayEquals(
            intArrayOf(1, 2, 3, 4),
            solution.findThePrefixCommonArray(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(1, 2, 3, 4)
            )
        )
    }

    @Test
    fun reversedArraysHaveNoCommonPrefixUntilMiddleElement() {
        assertArrayEquals(
            intArrayOf(0, 1, 3),
            solution.findThePrefixCommonArray(
                intArrayOf(1, 2, 3),
                intArrayOf(3, 2, 1)
            )
        )
    }
}
