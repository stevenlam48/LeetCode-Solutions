package superpalindromes

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SuperpalindromesTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(4, solution.superpalindromesInRange("4", "1000"))
    }

    @Test
    fun testExample2() {
        assertEquals(70, solution.superpalindromesInRange("1", "1000000000000000000"))
    }

    @Test
    fun testSingleValue() {
        assertEquals(1, solution.superpalindromesInRange("1", "1"))
    }

    @Test
    fun testNoSuperPalindrome() {
        assertEquals(0, solution.superpalindromesInRange("10", "100"))
    }

    @Test
    fun testSmallRange() {
        assertEquals(2, solution.superpalindromesInRange("1", "9"))
    }
}
