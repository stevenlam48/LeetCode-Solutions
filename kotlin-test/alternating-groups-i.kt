package alternatinggroupsi

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AlternatingGroupsITest {
    @Test
    fun testExample1() {
        assertEquals(3, Solution().numberOfAlternatingGroups(intArrayOf(0, 1, 0, 0, 1)))
    }

    @Test
    fun testExample2() {
        assertEquals(1, Solution().numberOfAlternatingGroups(intArrayOf(0, 1, 1, 1)))
    }

    @Test
    fun testAllSame() {
        assertEquals(0, Solution().numberOfAlternatingGroups(intArrayOf(1, 1, 1)))
    }

    @Test
    fun testFullyAlternating() {
        assertEquals(1, Solution().numberOfAlternatingGroups(intArrayOf(0, 1, 0)))
        assertEquals(4, Solution().numberOfAlternatingGroups(intArrayOf(1, 0, 1, 0)))
    }
}
