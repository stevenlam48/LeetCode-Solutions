package nextgreaterelementiii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NextGreaterElementIiiTest {
    @Test
    fun `finds next greater permutation`() {
        assertEquals(21, Solution().nextGreaterElement(12))
        assertEquals(120, Solution().nextGreaterElement(102))
    }

    @Test
    fun `returns minus one when digits cannot form greater number`() {
        assertEquals(-1, Solution().nextGreaterElement(21))
        assertEquals(-1, Solution().nextGreaterElement(1))
    }

    @Test
    fun `skips duplicate digits correctly`() {
        assertEquals(13222344, Solution().nextGreaterElement(12443322))
    }

    @Test
    fun `returns minus one on integer overflow`() {
        assertEquals(-1, Solution().nextGreaterElement(2147483647))
        assertEquals(-1, Solution().nextGreaterElement(1999999999))
    }
}
