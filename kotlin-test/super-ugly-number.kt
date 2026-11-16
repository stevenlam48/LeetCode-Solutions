package superuglynumber

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SuperUglyNumberTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(32, solution.nthSuperUglyNumber(12, intArrayOf(2, 7, 13, 19)))
    }

    @Test
    fun testExample2() {
        assertEquals(1, solution.nthSuperUglyNumber(1, intArrayOf(2, 3, 5)))
    }

    @Test
    fun testSinglePrime() {
        assertEquals(8, solution.nthSuperUglyNumber(4, intArrayOf(2)))
    }

    @Test
    fun testDuplicatesInSequence() {
        assertEquals(8, solution.nthSuperUglyNumber(6, intArrayOf(2, 3)))
    }

    @Test
    fun testFifthValue() {
        assertEquals(5, solution.nthSuperUglyNumber(5, intArrayOf(2, 3, 5)))
    }
}
