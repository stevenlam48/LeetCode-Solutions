package randompickwithblacklist

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RandomPickWithBlacklistTest {
    @Test
    fun testExample() {
        val solution = Solution(4, intArrayOf(2))
        val seen = HashSet<Int>()
        repeat(2000) {
            val value = solution.pick()
            assertTrue(value in 0..3)
            assertNotEquals(2, value)
            seen.add(value)
        }
        assertEquals(setOf(0, 1, 3), seen)
    }

    @Test
    fun testNoBlacklist() {
        val solution = Solution(1, intArrayOf())
        repeat(10) {
            assertEquals(0, solution.pick())
        }
    }

    @Test
    fun testBlacklistAtEnd() {
        val solution = Solution(5, intArrayOf(4))
        val seen = HashSet<Int>()
        repeat(2000) {
            val value = solution.pick()
            assertTrue(value in 0..3)
            seen.add(value)
        }
        assertEquals(setOf(0, 1, 2, 3), seen)
    }

    @Test
    fun testMultipleBlacklist() {
        val solution = Solution(10, intArrayOf(0, 3, 7))
        val seen = HashSet<Int>()
        repeat(3000) {
            val value = solution.pick()
            assertTrue(value in 0..9)
            assertFalse(value in setOf(0, 3, 7))
            seen.add(value)
        }
        assertEquals(setOf(1, 2, 4, 5, 6, 8, 9), seen)
    }
}
