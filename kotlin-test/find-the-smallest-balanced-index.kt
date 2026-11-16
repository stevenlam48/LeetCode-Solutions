package findthesmallestbalancedindex

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindTheSmallestBalancedIndexTest {

    private val solution = Solution()

    @Test
    fun testPrefixEqualsSuffix() {
        assertEquals(1, solution.smallestBalancedIndex(intArrayOf(1, 1)))
    }

    @Test
    fun testThreeElements() {
        assertEquals(1, solution.smallestBalancedIndex(intArrayOf(1, 1, 1)))
    }

    @Test
    fun testLargerValues() {
        assertEquals(2, solution.smallestBalancedIndex(intArrayOf(1, 1, 2, 2)))
        assertEquals(1, solution.smallestBalancedIndex(intArrayOf(10, 1, 1, 10)))
    }

    @Test
    fun testNoBalancedIndex() {
        assertEquals(-1, solution.smallestBalancedIndex(intArrayOf(2, 2)))
        assertEquals(-1, solution.smallestBalancedIndex(intArrayOf(5)))
        assertEquals(-1, solution.smallestBalancedIndex(intArrayOf(3, 1, 2, 3)))
    }
}
