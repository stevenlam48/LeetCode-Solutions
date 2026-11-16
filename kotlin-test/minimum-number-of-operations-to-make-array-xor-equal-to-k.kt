package minimumnumberofoperationstomakearrayxorequaltok

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfOperationsToMakeArrayXorEqualToKTest {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(2, solution.minOperations(intArrayOf(2, 1, 3, 4), 1))
    }

    @Test
    fun xorAlreadyEqual() {
        assertEquals(0, solution.minOperations(intArrayOf(2, 0, 2, 0), 0))
    }

    @Test
    fun singleBitDifference() {
        assertEquals(1, solution.minOperations(intArrayOf(1, 2, 3), 1))
    }

    @Test
    fun emptyArray() {
        assertEquals(3, solution.minOperations(intArrayOf(), 7))
    }
}
