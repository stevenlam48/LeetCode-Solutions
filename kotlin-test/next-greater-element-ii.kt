package nextgreaterelementii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class NextGreaterElementIiTest {
    @Test
    fun `finds next greater values in circular array`() {
        assertArrayEquals(intArrayOf(2, -1, 2), Solution().nextGreaterElements(intArrayOf(1, 2, 1)))
    }

    @Test
    fun `handles strictly increasing array`() {
        assertArrayEquals(intArrayOf(2, 3, -1), Solution().nextGreaterElements(intArrayOf(1, 2, 3)))
    }

    @Test
    fun `handles duplicates and single values`() {
        assertArrayEquals(intArrayOf(-1, -1, -1), Solution().nextGreaterElements(intArrayOf(5, 5, 5)))
        assertArrayEquals(intArrayOf(-1), Solution().nextGreaterElements(intArrayOf(1)))
    }

    @Test
    fun `handles empty input`() {
        assertArrayEquals(IntArray(0), Solution().nextGreaterElements(IntArray(0)))
    }
}
