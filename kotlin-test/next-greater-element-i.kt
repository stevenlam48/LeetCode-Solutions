package nextgreaterelementi

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class NextGreaterElementITest {
    @Test
    fun `finds next greater values including missing greater`() {
        assertArrayEquals(
            intArrayOf(-1, 3, -1),
            Solution().nextGreaterElement(intArrayOf(4, 1, 2), intArrayOf(1, 3, 4, 2))
        )
    }

    @Test
    fun `finds next greater values to the right`() {
        assertArrayEquals(
            intArrayOf(2, 3, -1),
            Solution().nextGreaterElement(intArrayOf(1, 2, 3), intArrayOf(1, 2, 3))
        )
    }

    @Test
    fun `handles empty subset`() {
        assertArrayEquals(IntArray(0), Solution().nextGreaterElement(IntArray(0), intArrayOf(2, 1, 3)))
    }

    @Test
    fun `handles descending array`() {
        assertArrayEquals(intArrayOf(-1, -1), Solution().nextGreaterElement(intArrayOf(3, 2), intArrayOf(3, 2, 1)))
    }
}
