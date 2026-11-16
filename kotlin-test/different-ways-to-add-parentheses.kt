package differentwaystoaddparentheses

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DifferentWaysToAddParenthesesTest {
    @Test
    fun testExample1() {
        assertEquals(listOf(0, 2), Solution().diffWaysToCompute("2-1-1").sorted())
    }

    @Test
    fun testExample2() {
        assertEquals(listOf(-34, -14, -10, -10, 10), Solution().diffWaysToCompute("2*3-4*5").sorted())
    }

    @Test
    fun testSingleNumber() {
        assertEquals(listOf(42), Solution().diffWaysToCompute("42"))
    }

    @Test
    fun testTwoNumbers() {
        assertEquals(listOf(5), Solution().diffWaysToCompute("2+3"))
        assertEquals(listOf(-1), Solution().diffWaysToCompute("2-3"))
        assertEquals(listOf(6), Solution().diffWaysToCompute("2*3"))
    }

    @Test
    fun testAllSameOperator() {
        assertEquals(listOf(6, 6), Solution().diffWaysToCompute("1+2+3"))
        assertEquals(listOf(0, 0), Solution().diffWaysToCompute("1-1-0"))
    }
}
