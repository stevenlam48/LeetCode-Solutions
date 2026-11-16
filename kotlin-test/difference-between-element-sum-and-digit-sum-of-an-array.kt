package differencebetweenelementsumanddigitsumofanarray

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DifferenceBetweenElementSumAndDigitSumOfAnArrayTest {
    @Test
    fun testExample1() {
        assertEquals(9, Solution().differenceOfSum(intArrayOf(1, 15, 6, 3)))
    }

    @Test
    fun testExample2() {
        assertEquals(0, Solution().differenceOfSum(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun testSingleElement() {
        assertEquals(0, Solution().differenceOfSum(intArrayOf(7)))
        assertEquals(9, Solution().differenceOfSum(intArrayOf(10)))
    }

    @Test
    fun testLargeNumbers() {
        assertEquals(999, Solution().differenceOfSum(intArrayOf(1000)))
        assertEquals(81, Solution().differenceOfSum(intArrayOf(99)))
    }
}
