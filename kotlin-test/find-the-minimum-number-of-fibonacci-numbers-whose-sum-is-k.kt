package findtheminimumnumberoffibonaccinumberswhosesumisk

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsKTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().findMinFibonacciNumbers(7))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().findMinFibonacciNumbers(10))
    }

    @Test
    fun example3() {
        assertEquals(3, Solution().findMinFibonacciNumbers(19))
    }

    @Test
    fun one() {
        assertEquals(1, Solution().findMinFibonacciNumbers(1))
    }
}
