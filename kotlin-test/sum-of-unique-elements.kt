package sumofuniqueelements

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SumOfUniqueElementsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(4, solution.sumOfUnique(intArrayOf(1, 2, 3, 2)))
    }

    @Test
    fun testExample2() {
        assertEquals(0, solution.sumOfUnique(intArrayOf(1, 1, 1, 1, 1)))
    }

    @Test
    fun testExample3() {
        assertEquals(15, solution.sumOfUnique(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun testEmpty() {
        assertEquals(0, solution.sumOfUnique(intArrayOf()))
    }

    @Test
    fun testNegatives() {
        assertEquals(-3, solution.sumOfUnique(intArrayOf(-1, -2, -1, -2, -3)))
    }
}
