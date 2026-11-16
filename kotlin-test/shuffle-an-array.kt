package shuffleanarray

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotSame
import org.junit.jupiter.api.Test

class ShuffleAnArrayTest {
    @Test
    fun `reset restores original array`() {
        val original = intArrayOf(1, 2, 3, 4)
        val solution = Solution(original)
        original[0] = 99
        assertArrayEquals(intArrayOf(1, 2, 3, 4), solution.reset())
        solution.shuffle()
        assertArrayEquals(intArrayOf(1, 2, 3, 4), solution.reset())
    }

    @Test
    fun `shuffle returns a permutation without changing original`() {
        val solution = Solution(intArrayOf(1, 2, 2, 3, 4, 5))
        val shuffled = solution.shuffle()
        assertEquals(6, shuffled.size)
        assertArrayEquals(intArrayOf(1, 2, 2, 3, 4, 5), shuffled.sortedArray())
        assertArrayEquals(intArrayOf(1, 2, 2, 3, 4, 5), solution.reset())
    }

    @Test
    fun `returned arrays have independent storage`() {
        val solution = Solution(intArrayOf(1, 2, 3))
        val reset = solution.reset()
        assertNotSame(reset, solution.reset())
        reset[0] = 100
        assertArrayEquals(intArrayOf(1, 2, 3), solution.reset())
    }

    @Test
    fun `empty and singleton arrays`() {
        assertArrayEquals(intArrayOf(), Solution(intArrayOf()).shuffle())
        assertArrayEquals(intArrayOf(7), Solution(intArrayOf(7)).shuffle())
    }
}
