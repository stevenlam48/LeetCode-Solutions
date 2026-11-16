package countevenlygoodintegers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountEvenlyGoodIntegersTest {
    @Test
    fun singleDigits() {
        assertEquals(5L, Solution().countEvenlyGoodIntegers(1L, 9L))
    }

    @Test
    fun includingTen() {
        assertEquals(5L, Solution().countEvenlyGoodIntegers(1L, 10L))
    }

    @Test
    fun upToTwenty() {
        assertEquals(11L, Solution().countEvenlyGoodIntegers(1L, 20L))
    }

    @Test
    fun upToHundred() {
        assertEquals(51L, Solution().countEvenlyGoodIntegers(1L, 100L))
    }

    @Test
    fun boundaryValues() {
        assertEquals(0L, Solution().countEvenlyGoodIntegers(0L, 0L))
        assertEquals(0L, Solution().countEvenlyGoodIntegers(10L, 10L))
        assertEquals(1L, Solution().countEvenlyGoodIntegers(20L, 20L))
    }
}
