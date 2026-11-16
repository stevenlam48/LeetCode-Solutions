package digitoperationstomaketwointegersequal

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DigitOperationsToMakeTwoIntegersEqualTest {
    @Test
    fun testExample1() {
        assertEquals(85, Solution().minOperations(10, 12))
    }

    @Test
    fun testExample2() {
        assertEquals(-1, Solution().minOperations(4, 3))
    }

    @Test
    fun testExample3() {
        assertEquals(-1, Solution().minOperations(6, 2))
    }

    @Test
    fun testSameNumber() {
        assertEquals(-1, Solution().minOperations(7, 7))
    }

    @Test
    fun testPrimeStart() {
        assertEquals(-1, Solution().minOperations(2, 3))
    }
}
