package alternatinggroupsii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AlternatingGroupsIITest {
    @Test
    fun testExample1() {
        assertEquals(3, Solution().numberOfAlternatingGroups(intArrayOf(0, 1, 0, 1, 0), 3))
    }

    @Test
    fun testExample2() {
        assertEquals(2, Solution().numberOfAlternatingGroups(intArrayOf(0, 1, 0, 0, 1, 0, 1), 6))
    }

    @Test
    fun testExample3() {
        assertEquals(0, Solution().numberOfAlternatingGroups(intArrayOf(1, 1, 0, 1), 4))
    }

    @Test
    fun testWholeCircleAlternating() {
        assertEquals(1, Solution().numberOfAlternatingGroups(intArrayOf(0, 1, 0), 3))
    }
}
