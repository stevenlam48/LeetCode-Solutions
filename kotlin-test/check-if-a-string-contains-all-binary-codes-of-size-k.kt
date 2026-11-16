package checkifastringcontainsallbinarycodesofsizek

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class CheckIfAStringContainsAllBinaryCodesOfSizeKTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertTrue(solution.hasAllCodes("00110110", 2))
    }

    @Test
    fun testExample2() {
        assertTrue(solution.hasAllCodes("0110", 1))
    }

    @Test
    fun testExample3() {
        assertFalse(solution.hasAllCodes("0110", 2))
    }

    @Test
    fun testExample4() {
        assertFalse(solution.hasAllCodes("0000000001011100", 4))
    }

    @Test
    fun testKTooLarge() {
        assertFalse(solution.hasAllCodes("0", 1))
    }

    @Test
    fun testExactLength() {
        assertTrue(solution.hasAllCodes("01", 1))
    }
}
