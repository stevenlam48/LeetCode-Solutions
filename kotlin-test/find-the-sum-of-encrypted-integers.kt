package findthesumofencryptedintegers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindTheSumOfEncryptedIntegersTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(6, solution.sumOfEncryptedInt(intArrayOf(1, 2, 3)))
    }

    @Test
    fun testExample2() {
        assertEquals(66, solution.sumOfEncryptedInt(intArrayOf(10, 21, 31)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(4444, solution.sumOfEncryptedInt(intArrayOf(1234)))
    }

    @Test
    fun testAllSameDigit() {
        assertEquals(999, solution.sumOfEncryptedInt(intArrayOf(999)))
    }

    @Test
    fun testLeadingZeroDigit() {
        assertEquals(11, solution.sumOfEncryptedInt(intArrayOf(10)))
    }
}
