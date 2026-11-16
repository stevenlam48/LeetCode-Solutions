package singlenumber

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SingleNumberTest {
    private val solution = Solution()

    @Test
    fun `one unpaired value`() {
        assertEquals(1, solution.singleNumber(intArrayOf(2, 2, 1)))
    }

    @Test
    fun `unpaired value among multiple pairs`() {
        assertEquals(4, solution.singleNumber(intArrayOf(4, 1, 2, 1, 2)))
    }

    @Test
    fun `single input value`() {
        assertEquals(1, solution.singleNumber(intArrayOf(1)))
    }

    @Test
    fun `handles zero and negatives`() {
        assertEquals(-7, solution.singleNumber(intArrayOf(-1, 0, -1, 0, -7)))
    }
}
