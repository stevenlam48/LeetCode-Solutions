package smallestmissingmultipleofk

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SmallestMissingMultipleOfKTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(5, solution.missingMultiple(intArrayOf(8, 2, 3, 4, 6), 5))
    }

    @Test
    fun testExample2() {
        assertEquals(6, solution.missingMultiple(intArrayOf(1, 2, 3, 4, 5), 1))
    }

    @Test
    fun testExample3() {
        assertEquals(2, solution.missingMultiple(intArrayOf(7, 8, 9, 10, 11), 2))
    }

    @Test
    fun testSingleElement() {
        assertEquals(2, solution.missingMultiple(intArrayOf(1), 2))
    }

    @Test
    fun testAllMultiplesPresent() {
        assertEquals(8, solution.missingMultiple(intArrayOf(2, 4, 6), 2))
    }
}
