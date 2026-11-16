package convertintegertothesumoftwonozerointegers

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ConvertIntegerToTheSumOfTwoNoZeroIntegersTest {
    private val solution = Solution()

    private fun hasNoZero(x: Int) = !x.toString().contains('0')

    @Test
    fun testExampleTwo() {
        assertArrayEquals(intArrayOf(1, 1), solution.getNoZeroIntegers(2))
    }

    @Test
    fun testEleven() {
        assertArrayEquals(intArrayOf(2, 9), solution.getNoZeroIntegers(11))
    }

    @Test
    fun testTen() {
        assertArrayEquals(intArrayOf(2, 8), solution.getNoZeroIntegers(10))
    }

    @Test
    fun testSumAndNoZeroDigits() {
        for (n in 2..200) {
            val result = solution.getNoZeroIntegers(n)
            assertEquals(n, result[0] + result[1])
            assertTrue(hasNoZero(result[0]))
            assertTrue(hasNoZero(result[1]))
        }
    }
}
