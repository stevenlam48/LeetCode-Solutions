package parallelcourses

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ParallelCoursesTest {
    @Test
    fun testExample() {
        val relations = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 3)
        )
        assertEquals(2, Solution().minimumSemesters(3, relations))
    }

    @Test
    fun testChain() {
        val relations = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3)
        )
        assertEquals(3, Solution().minimumSemesters(3, relations))
    }

    @Test
    fun testCycle() {
        val relations = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 1)
        )
        assertEquals(-1, Solution().minimumSemesters(3, relations))
    }

    @Test
    fun testNoPrerequisites() {
        assertEquals(1, Solution().minimumSemesters(1, arrayOf()))
        assertEquals(1, Solution().minimumSemesters(3, arrayOf()))
    }

    @Test
    fun testLayeredGraph() {
        val relations = arrayOf(
            intArrayOf(1, 5),
            intArrayOf(2, 5),
            intArrayOf(3, 6),
            intArrayOf(4, 6),
            intArrayOf(5, 7),
            intArrayOf(6, 7)
        )
        assertEquals(3, Solution().minimumSemesters(7, relations))
    }
}
