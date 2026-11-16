package checkifdigitsareequalinstringafteroperationsii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CheckIfDigitsAreEqualInStringAfterOperationsIITest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.hasSameDigits("3902"))
    }

    @Test
    fun testExample2() {
        assertFalse(solution.hasSameDigits("34789"))
    }

    @Test
    fun testRepeatedDigit() {
        assertTrue(solution.hasSameDigits("777"))
    }

    @Test
    fun testTwoEqualDigits() {
        assertTrue(solution.hasSameDigits("11"))
    }

    @Test
    fun testTwoDifferentDigits() {
        assertFalse(solution.hasSameDigits("12"))
    }

    @Test
    fun testTenDigits() {
        assertFalse(solution.hasSameDigits("1234567890"))
    }
}
