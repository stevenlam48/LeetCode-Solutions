package makearrayempty

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MakeArrayEmptyTest {
    @Test
    fun wrapsAroundAfterRemovingNegativeValue() {
        assertEquals(5L, Solution().countOperationsToEmptyArray(intArrayOf(3, 4, -1)))
    }

    @Test
    fun countsFinalWrapForDescendingLargestValues() {
        assertEquals(5L, Solution().countOperationsToEmptyArray(intArrayOf(1, 2, 4, 3)))
    }

    @Test
    fun handlesDuplicateValues() {
        assertEquals(6L, Solution().countOperationsToEmptyArray(intArrayOf(2, 1, 2, 1)))
    }

    @Test
    fun sortedArrayTakesOnePass() {
        assertEquals(4L, Solution().countOperationsToEmptyArray(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun handlesEmptyAndSingleElementArrays() {
        assertEquals(0L, Solution().countOperationsToEmptyArray(intArrayOf()))
        assertEquals(1L, Solution().countOperationsToEmptyArray(intArrayOf(9)))
    }
}
