package shufflethearray

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ShuffleTheArrayTest {
    private val solution = Solution()

    @Test
    fun `three pairs`() {
        assertArrayEquals(intArrayOf(2, 3, 5, 4, 1, 7), solution.shuffle(intArrayOf(2, 5, 1, 3, 4, 7), 3))
    }

    @Test
    fun `four pairs with interleaved values`() {
        assertArrayEquals(intArrayOf(1, 4, 2, 3, 3, 2, 4, 1), solution.shuffle(intArrayOf(1, 2, 3, 4, 4, 3, 2, 1), 4))
    }

    @Test
    fun `one pair`() {
        assertArrayEquals(intArrayOf(1, 2), solution.shuffle(intArrayOf(1, 2), 1))
    }

    @Test
    fun `duplicate values`() {
        assertArrayEquals(intArrayOf(5, 5, 5, 5), solution.shuffle(intArrayOf(5, 5, 5, 5), 2))
    }
}
