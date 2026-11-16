package rangesumqueryimmutable
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class RangeSumQueryImmutableTest {
    @Test
    fun leetCodeExample() {
        val numArray = NumArray(intArrayOf(-2, 0, 3, -5, 2, -1))
        assertEquals(1, numArray.sumRange(0, 2))
        assertEquals(-1, numArray.sumRange(2, 5))
        assertEquals(-3, numArray.sumRange(0, 5))
    }

    @Test
    fun singleElements() {
        val numArray = NumArray(intArrayOf(4, -7, 9))
        assertEquals(4, numArray.sumRange(0, 0))
        assertEquals(-7, numArray.sumRange(1, 1))
        assertEquals(9, numArray.sumRange(2, 2))
    }

    @Test
    fun emptyInput() {
        assertDoesNotThrow { NumArray(intArrayOf()) }
    }
}
