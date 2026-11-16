package parallelcoursesii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ParallelCoursesIiTest {
    @Test
    fun testExampleOne() {
        val dependencies = arrayOf(
            intArrayOf(2, 1),
            intArrayOf(3, 1),
            intArrayOf(1, 4)
        )
        assertEquals(3, Solution().minNumberOfSemesters(4, dependencies, 2))
    }

    @Test
    fun testExampleTwo() {
        val dependencies = arrayOf(
            intArrayOf(2, 1),
            intArrayOf(3, 1),
            intArrayOf(4, 1),
            intArrayOf(1, 5)
        )
        assertEquals(4, Solution().minNumberOfSemesters(5, dependencies, 2))
    }

    @Test
    fun testNoDependencies() {
        assertEquals(2, Solution().minNumberOfSemesters(3, arrayOf(), 2))
        assertEquals(3, Solution().minNumberOfSemesters(3, arrayOf(), 1))
    }

    @Test
    fun testChainWithLargeK() {
        val dependencies = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4)
        )
        assertEquals(4, Solution().minNumberOfSemesters(4, dependencies, 10))
    }

    @Test
    fun testSingleCourse() {
        assertEquals(1, Solution().minNumberOfSemesters(1, arrayOf(), 1))
    }
}
