package minimumnumberofincrementsonsubarraystoformatargetarray

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfIncrementsOnSubarraysToFormATargetArrayTest {
    private val solution = Solution()

    @Test
    fun mountainShape() {
        assertEquals(3, solution.minNumberOperations(intArrayOf(1, 2, 3, 2, 1)))
    }

    @Test
    fun dropThenRise() {
        assertEquals(4, solution.minNumberOperations(intArrayOf(3, 1, 1, 2)))
    }

    @Test
    fun constantArray() {
        assertEquals(1, solution.minNumberOperations(intArrayOf(1, 1, 1)))
    }

    @Test
    fun singleElement() {
        assertEquals(5, solution.minNumberOperations(intArrayOf(5)))
    }

    @Test
    fun emptyArray() {
        assertEquals(0, solution.minNumberOperations(intArrayOf()))
    }
}
