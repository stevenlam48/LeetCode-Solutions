package findsmallestcommonelementinallrows

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindSmallestCommonElementInAllRowsTest {
    @Test
    fun testExample1() {
        val mat = arrayOf(
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(2, 4, 5, 8, 10),
            intArrayOf(3, 5, 7, 9, 11),
            intArrayOf(1, 3, 5, 7, 9)
        )
        assertEquals(5, Solution().smallestCommonElement(mat))
    }

    @Test
    fun testExample2() {
        val mat = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(2, 3, 4),
            intArrayOf(2, 3, 5)
        )
        assertEquals(2, Solution().smallestCommonElement(mat))
    }

    @Test
    fun testNoCommonElement() {
        val mat = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )
        assertEquals(-1, Solution().smallestCommonElement(mat))
    }

    @Test
    fun testSingleRow() {
        val mat = arrayOf(intArrayOf(4, 1, 3))
        assertEquals(1, Solution().smallestCommonElement(mat))
    }
}
