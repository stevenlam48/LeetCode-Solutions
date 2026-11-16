package findallnumbersdisappearedinanarray

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindAllNumbersDisappearedInAnArrayTest {
    @Test
    fun exampleWithDuplicates() {
        assertEquals(listOf(5, 6), Solution().findDisappearedNumbers(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)))
    }

    @Test
    fun repeatedSingleValue() {
        assertEquals(listOf(2), Solution().findDisappearedNumbers(intArrayOf(1, 1)))
    }

    @Test
    fun noMissingNumbersAndInputRestored() {
        val nums = intArrayOf(3, 1, 2)
        assertEquals(emptyList<Int>(), Solution().findDisappearedNumbers(nums))
        assertArrayEquals(intArrayOf(3, 1, 2), nums)
    }
}
