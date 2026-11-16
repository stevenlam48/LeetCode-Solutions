package countvalidpathsinatree

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountValidPathsInATreeTest {
    @Test
    fun `leetcode example`() {
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(2, 4),
            intArrayOf(2, 5)
        )

        assertEquals(4L, Solution().countPaths(5, edges))
    }

    @Test
    fun `single composite node`() {
        assertEquals(0L, Solution().countPaths(1, emptyArray()))
    }

    @Test
    fun `single prime and composite pair`() {
        val edges = arrayOf(intArrayOf(1, 2))

        assertEquals(1L, Solution().countPaths(2, edges))
    }

    @Test
    fun `three node path through two prime nodes`() {
        val edges = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3))

        assertEquals(1L, Solution().countPaths(3, edges))
    }

    @Test
    fun `four node path excludes paths through two primes`() {
        val edges = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4)
        )

        assertEquals(2L, Solution().countPaths(4, edges))
    }
}
