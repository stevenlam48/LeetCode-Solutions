package findifpathexistsingraph

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindIfPathExistsInGraphTest {
    @Test
    fun standardExample() {
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 0)
        )
        assertTrue(Solution().validPath(3, edges, 0, 2))
    }

    @Test
    fun disconnectedComponents() {
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(3, 5),
            intArrayOf(5, 4),
            intArrayOf(4, 3)
        )
        assertFalse(Solution().validPath(6, edges, 0, 5))
    }

    @Test
    fun singleNode() {
        assertTrue(Solution().validPath(1, arrayOf(), 0, 0))
    }

    @Test
    fun directEdge() {
        val edges = arrayOf(intArrayOf(0, 1))
        assertTrue(Solution().validPath(2, edges, 0, 1))
    }

    @Test
    fun longPath() {
        val edges = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4)
        )
        assertTrue(Solution().validPath(5, edges, 0, 4))
    }
}
