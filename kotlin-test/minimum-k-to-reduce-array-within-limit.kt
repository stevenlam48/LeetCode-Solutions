package minimumktoreducearraywithinlimit

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumKToReduceArrayWithinLimitTest {
    private val solution = Solution()

    @Test
    fun findsMinimumForGeneralArray() {
        assertEquals(3, solution.minimumK(intArrayOf(2, 4, 6)))
    }

    @Test
    fun singleElementOneUsesKOne() {
        assertEquals(1, solution.minimumK(intArrayOf(1)))
    }

    @Test
    fun operationCountLimitRequiresKAboveLargestValue() {
        assertEquals(3, solution.minimumK(intArrayOf(1, 1, 1, 1, 1)))
    }

    @Test
    fun checksSquaredKLimitAcrossAllElements() {
        assertEquals(4, solution.minimumK(intArrayOf(9, 8, 7, 6)))
    }
}
