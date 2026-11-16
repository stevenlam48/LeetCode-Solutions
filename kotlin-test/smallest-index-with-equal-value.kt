package smallestindexwithequalvalue

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SmallestIndexWithEqualValueTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(0, solution.smallestEqual(intArrayOf(0, 1, 2)))
    }

    @Test
    fun testExample2() {
        assertEquals(2, solution.smallestEqual(intArrayOf(4, 3, 2, 1)))
    }

    @Test
    fun testExample3() {
        assertEquals(-1, solution.smallestEqual(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0, solution.smallestEqual(intArrayOf(0)))
    }

    @Test
    fun testIndexModuloTen() {
        assertEquals(10, solution.smallestEqual(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0)))
    }
}
