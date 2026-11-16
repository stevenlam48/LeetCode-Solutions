package findthecountofgoodintegers

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindTheCountOfGoodIntegersTest {
    @Test
    fun countsThreeDigitGoodIntegers() {
        assertEquals(27L, Solution().countGoodIntegers(3, 5))
    }

    @Test
    fun countsAllSingleDigitIntegersForOne() {
        assertEquals(9L, Solution().countGoodIntegers(1, 1))
    }

    @Test
    fun countsRepeatedDigitPalindromes() {
        assertEquals(4L, Solution().countGoodIntegers(2, 2))
    }

    @Test
    fun handlesLargerCombinatoricsExample() {
        assertEquals(2468L, Solution().countGoodIntegers(5, 6))
    }
}
