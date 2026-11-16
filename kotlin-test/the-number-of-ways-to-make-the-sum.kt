package thenumberofwaystomakethesum

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TheNumberOfWaysToMakeTheSumTest {

    @Test
    fun testOne() {
        assertEquals(1, Solution().numberOfWays(1))
    }

    @Test
    fun testTwo() {
        assertEquals(2, Solution().numberOfWays(2))
    }

    @Test
    fun testThree() {
        assertEquals(2, Solution().numberOfWays(3))
    }

    @Test
    fun testFour() {
        assertEquals(4, Solution().numberOfWays(4))
    }

    @Test
    fun testSix() {
        assertEquals(7, Solution().numberOfWays(6))
    }

    @Test
    fun testTen() {
        assertEquals(16, Solution().numberOfWays(10))
    }
}
