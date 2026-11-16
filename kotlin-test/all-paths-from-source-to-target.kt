package allpathsfromsourcetotarget

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AllPathsFromSourceToTargetTest {
    @Test
    fun testExample1() {
        val graph = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3),
            intArrayOf(3),
            intArrayOf()
        )
        val expected = listOf(listOf(0, 1, 3), listOf(0, 2, 3))
        assertEquals(expected, Solution().allPathsSourceTarget(graph))
    }

    @Test
    fun testExample2() {
        val graph = arrayOf(
            intArrayOf(4, 3, 1),
            intArrayOf(3, 2, 4),
            intArrayOf(3),
            intArrayOf(4),
            intArrayOf()
        )
        val expected = listOf(
            listOf(0, 4),
            listOf(0, 3, 4),
            listOf(0, 1, 3, 4),
            listOf(0, 1, 2, 3, 4),
            listOf(0, 1, 4)
        )
        assertEquals(expected, Solution().allPathsSourceTarget(graph))
    }

    @Test
    fun testTwoNodes() {
        val graph = arrayOf(intArrayOf(1), intArrayOf())
        assertEquals(listOf(listOf(0, 1)), Solution().allPathsSourceTarget(graph))
    }

    @Test
    fun testSingleNode() {
        val graph = arrayOf(intArrayOf())
        assertEquals(listOf(listOf(0)), Solution().allPathsSourceTarget(graph))
    }
}
