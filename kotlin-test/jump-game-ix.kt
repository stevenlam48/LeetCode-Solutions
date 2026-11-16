package jumpgameix

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class JumpGameIxTest {
    @Test
    fun `propagates the segment maximum left`() {
        assertArrayEquals(intArrayOf(2, 2, 3), Solution().maxValue(intArrayOf(2, 1, 3)))
    }

    @Test
    fun `suffix minimum joins every value into the latter segment`() {
        assertArrayEquals(intArrayOf(3, 3, 3), Solution().maxValue(intArrayOf(2, 3, 1)))
    }

    @Test
    fun `descending values share the maximum`() {
        assertArrayEquals(intArrayOf(5, 5, 5, 5, 5), Solution().maxValue(intArrayOf(5, 4, 3, 2, 1)))
    }

    @Test
    fun `handles multiple segments`() {
        assertArrayEquals(intArrayOf(1, 3, 3, 3, 5), Solution().maxValue(intArrayOf(1, 2, 3, 1, 5)))
    }

    @Test
    fun `single element`() {
        assertArrayEquals(intArrayOf(7), Solution().maxValue(intArrayOf(7)))
    }
}
