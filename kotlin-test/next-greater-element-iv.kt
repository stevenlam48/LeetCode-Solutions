package nextgreaterelementiv

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class NextGreaterElementIvTest {
    @Test
    fun `finds second greater elements`() {
        assertArrayEquals(intArrayOf(9, 6, 6, -1, -1), Solution().secondGreaterElement(intArrayOf(2, 4, 0, 9, 6)))
    }

    @Test
    fun `handles repeated values`() {
        assertArrayEquals(intArrayOf(-1, -1), Solution().secondGreaterElement(intArrayOf(3, 3)))
        assertArrayEquals(intArrayOf(-1, -1, -1), Solution().secondGreaterElement(intArrayOf(1, 1, 2)))
        assertArrayEquals(intArrayOf(3, -1, -1, -1), Solution().secondGreaterElement(intArrayOf(1, 2, 1, 3)))
    }

    @Test
    fun `handles monotonic array`() {
        assertArrayEquals(intArrayOf(3, 4, -1, -1), Solution().secondGreaterElement(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun `handles empty and single element arrays`() {
        assertArrayEquals(IntArray(0), Solution().secondGreaterElement(IntArray(0)))
        assertArrayEquals(intArrayOf(-1), Solution().secondGreaterElement(intArrayOf(5)))
    }
}
