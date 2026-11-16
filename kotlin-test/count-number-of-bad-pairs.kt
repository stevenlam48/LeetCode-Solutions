package countnumberofbadpairs

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CountNumberOfBadPairsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(5L, solution.countBadPairs(intArrayOf(4, 1, 3, 3)))
    }

    @Test
    fun testExample2() {
        assertEquals(0L, solution.countBadPairs(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0L, solution.countBadPairs(intArrayOf(1)))
    }

    @Test
    fun testAllBad() {
        assertEquals(3L, solution.countBadPairs(intArrayOf(1, 1, 1)))
    }
}
