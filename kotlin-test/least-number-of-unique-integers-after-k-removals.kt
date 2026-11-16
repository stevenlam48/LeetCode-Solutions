package leastnumberofuniqueintegersafterkremovals

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LeastNumberOfUniqueIntegersAfterKRemovalsTest {
    private val solution = Solution()

    @Test
    fun removesSingleOccurrenceValueFirst() {
        assertEquals(1, solution.findLeastNumOfUniqueInts(intArrayOf(5, 5, 4), 1))
    }

    @Test
    fun handlesLeetCodeExampleWithPartialRemovalGroup() {
        val arr = intArrayOf(4, 3, 1, 1, 3, 3, 2)
        assertEquals(2, solution.findLeastNumOfUniqueInts(arr, 3))
    }

    @Test
    fun returnsOriginalUniqueCountWhenKIsZero() {
        assertEquals(3, solution.findLeastNumOfUniqueInts(intArrayOf(2, 2, 1, 3), 0))
    }

    @Test
    fun returnsZeroWhenKExceedsArrayLength() {
        assertEquals(0, solution.findLeastNumOfUniqueInts(intArrayOf(1, 2, 1, 3), 10))
    }

    @Test
    fun removesOneCompleteGroupAndPartOfAnother() {
        assertEquals(1, solution.findLeastNumOfUniqueInts(intArrayOf(1, 1, 2, 2, 3), 3))
    }

    @Test
    fun handlesEmptyArray() {
        assertEquals(0, solution.findLeastNumOfUniqueInts(intArrayOf(), 0))
    }
}
