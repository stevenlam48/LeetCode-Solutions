package shufflestring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ShuffleStringTest {
    private val solution = Solution()

    @Test
    fun `restores leetcode`() {
        val indices = intArrayOf(4, 5, 6, 7, 0, 2, 1, 3)
        assertEquals("leetcode", solution.restoreString("codeleet", indices))
    }

    @Test
    fun `reverses character positions`() {
        assertEquals("nihao", solution.restoreString("aiohn", intArrayOf(3, 1, 4, 2, 0)))
    }

    @Test
    fun `identity permutation`() {
        assertEquals("abc", solution.restoreString("abc", intArrayOf(0, 1, 2)))
    }

    @Test
    fun `single character`() {
        assertEquals("x", solution.restoreString("x", intArrayOf(0)))
    }
}
