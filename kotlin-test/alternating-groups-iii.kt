package alternatinggroupsiii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AlternatingGroupsIIITest {
    @Test
    fun testExample1() {
        val colors = intArrayOf(0, 1, 1, 0, 1)
        val queries = arrayOf(intArrayOf(2, 1, 0), intArrayOf(1, 4))
        assertEquals(listOf(2), Solution().numberOfAlternatingGroups(colors, queries))
    }

    @Test
    fun testExample2() {
        val colors = intArrayOf(0, 0, 1, 0, 1, 1)
        val queries = arrayOf(intArrayOf(2, 1, 0), intArrayOf(1, 5))
        assertEquals(listOf(0), Solution().numberOfAlternatingGroups(colors, queries))
    }

    @Test
    fun testMultipleQueries() {
        val colors = intArrayOf(0, 1, 0, 1, 0)
        val queries = arrayOf(intArrayOf(1, 3), intArrayOf(1, 5))
        assertEquals(listOf(3, 1), Solution().numberOfAlternatingGroups(colors, queries))
    }

    @Test
    fun testAllSameThenUpdate() {
        val colors = intArrayOf(1, 1, 1)
        val queries = arrayOf(intArrayOf(1, 3), intArrayOf(2, 0, 0), intArrayOf(1, 3))
        assertEquals(listOf(0, 1), Solution().numberOfAlternatingGroups(colors, queries))
    }
}
