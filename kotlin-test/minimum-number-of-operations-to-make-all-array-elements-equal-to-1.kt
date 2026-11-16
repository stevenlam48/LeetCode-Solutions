package minimumnumberofoperationstomakeallarrayelementsequalto1

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfOperationsToMakeAllArrayElementsEqualTo1Test {
    private val solution = Solution()

    @Test
    fun standardExample() {
        assertEquals(4, solution.minOperations(intArrayOf(2, 6, 3, 4)))
    }

    @Test
    fun impossibleCase() {
        assertEquals(-1, solution.minOperations(intArrayOf(2, 10, 6, 14)))
    }

    @Test
    fun existingOne() {
        assertEquals(1, solution.minOperations(intArrayOf(1, 5)))
    }

    @Test
    fun allOnes() {
        assertEquals(0, solution.minOperations(intArrayOf(1, 1, 1)))
    }

    @Test
    fun noPairWithGcdOne() {
        assertEquals(-1, solution.minOperations(intArrayOf(3, 3)))
    }
}
