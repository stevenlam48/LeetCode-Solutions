package subtracttheproductandsumofdigitsofaninteger

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SubtractTheProductAndSumOfDigitsOfAnIntegerTest {
    @Test
    fun exampleOne() {
        assertEquals(15, Solution().subtractProductAndSum(234))
    }

    @Test
    fun exampleTwo() {
        assertEquals(21, Solution().subtractProductAndSum(4421))
    }

    @Test
    fun singleDigit() {
        assertEquals(0, Solution().subtractProductAndSum(7))
    }

    @Test
    fun zeroAndContainingZero() {
        assertEquals(1, Solution().subtractProductAndSum(0))
        assertEquals(-6, Solution().subtractProductAndSum(105))
    }
}
