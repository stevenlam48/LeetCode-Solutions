package rangesumquerymutable
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class RangeSumQueryMutableTest {
    @Test
    fun leetCodeExample() {
        val numArray = NumArray(intArrayOf(1, 3, 5))
        assertEquals(9, numArray.sumRange(0, 2))
        numArray.update(1, 2)
        assertEquals(8, numArray.sumRange(0, 2))
    }

    @Test
    fun negativeValuesAndRepeatedUpdates() {
        val nums = intArrayOf(-4, 2, 7, -1)
        val numArray = NumArray(nums)
        assertEquals(4, numArray.sumRange(0, 3))
        numArray.update(2, -6)
        assertEquals(-9, numArray.sumRange(0, 3))
        assertEquals(-5, numArray.sumRange(1, 3))
        numArray.update(2, -6)
        assertEquals(-6, nums[2])
        numArray.update(0, 5)
        assertEquals(0, numArray.sumRange(0, 3))
    }

    @Test
    fun singleElementAndEmptyInput() {
        val numArray = NumArray(intArrayOf(3))
        assertEquals(3, numArray.sumRange(0, 0))
        numArray.update(0, -8)
        assertEquals(-8, numArray.sumRange(0, 0))
        assertDoesNotThrow { NumArray(intArrayOf()) }
    }
}
