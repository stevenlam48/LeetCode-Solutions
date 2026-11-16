package allocatemailboxes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AllocateMailboxesTest {
    @Test
    fun testExample1() {
        assertEquals(5, Solution().minDistance(intArrayOf(1, 4, 8, 10, 20), 3))
    }

    @Test
    fun testExample2() {
        assertEquals(9, Solution().minDistance(intArrayOf(2, 3, 5, 12, 18), 2))
    }

    @Test
    fun testOneMailbox() {
        assertEquals(8, Solution().minDistance(intArrayOf(7, 4, 6, 1), 1))
    }

    @Test
    fun testMailboxPerHouse() {
        assertEquals(0, Solution().minDistance(intArrayOf(3, 6, 14, 10), 4))
    }

    @Test
    fun testSingleHouse() {
        assertEquals(0, Solution().minDistance(intArrayOf(5), 1))
    }
}
