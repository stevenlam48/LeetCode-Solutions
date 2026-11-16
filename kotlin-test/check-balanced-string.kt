package checkbalancedstring

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckBalancedStringTest {
    private val solution = Solution()

    @Test
    fun balancedExample() {
        assertTrue(solution.isBalanced("24123"))
    }

    @Test
    fun unbalancedExample() {
        assertFalse(solution.isBalanced("1234"))
    }

    @Test
    fun leadingZerosCountAsDigits() {
        assertTrue(solution.isBalanced("0011"))
        assertFalse(solution.isBalanced("01"))
    }

    @Test
    fun emptyAndZero() {
        assertTrue(solution.isBalanced(""))
        assertTrue(solution.isBalanced("0"))
    }
}
