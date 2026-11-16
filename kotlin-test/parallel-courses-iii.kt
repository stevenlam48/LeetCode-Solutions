package parallelcoursesiii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class ParallelCoursesIiiTest {
    @Test
    fun testExampleOne() {
        val relations = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 3)
        )
        assertEquals(8, Solution().minimumTime(3, relations, intArrayOf(3, 2, 5)))
    }

    @Test
    fun testExampleTwo() {
        val relations = arrayOf(
            intArrayOf(1, 5),
            intArrayOf(2, 5),
            intArrayOf(3, 5),
            intArrayOf(4, 5)
        )
        assertEquals(9, Solution().minimumTime(5, relations, intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun testNoRelations() {
        assertEquals(2, Solution().minimumTime(2, arrayOf(), intArrayOf(1, 2)))
    }

    @Test
    fun testChain() {
        val relations = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3)
        )
        assertEquals(6, Solution().minimumTime(3, relations, intArrayOf(1, 2, 3)))
    }
}
