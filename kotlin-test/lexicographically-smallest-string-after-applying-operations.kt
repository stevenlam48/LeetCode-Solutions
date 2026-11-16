package lexicographicallysmalleststringafterapplyingoperations

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LexicographicallySmallestStringAfterApplyingOperationsTest {
    private val solution = Solution()

    @Test
    fun combinesAdditionAndRotationOperations() {
        assertEquals("2050", solution.findLexSmallestString("5525", 9, 2))
    }

    @Test
    fun oddRotationLengthAllowsChangingEvenIndices() {
        assertEquals("24", solution.findLexSmallestString("74", 5, 1))
    }

    @Test
    fun originalStringCanRemainSmallest() {
        assertEquals("0011", solution.findLexSmallestString("0011", 4, 2))
    }

    @Test
    fun zeroAdditionStillAllowsRotation() {
        assertEquals("02", solution.findLexSmallestString("20", 0, 1))
    }

    @Test
    fun repeatedOperationsCanReachZeroOnBothIndices() {
        assertEquals("00", solution.findLexSmallestString("22", 3, 1))
    }
}
