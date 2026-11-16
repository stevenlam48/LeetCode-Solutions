package thenumberoffullroundsyouhaveplayed

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TheNumberOfFullRoundsYouHavePlayedTest {

    @Test
    fun testExample1() {
        assertEquals(1, Solution().numberOfRounds("09:31", "10:14"))
    }

    @Test
    fun testExample2() {
        assertEquals(2, Solution().numberOfRounds("21:30", "22:00"))
    }

    @Test
    fun testExample3() {
        assertEquals(95, Solution().numberOfRounds("00:00", "23:59"))
    }

    @Test
    fun testNoFullRound() {
        assertEquals(0, Solution().numberOfRounds("00:47", "00:57"))
    }

    @Test
    fun testOvernight() {
        assertEquals(40, Solution().numberOfRounds("20:00", "06:00"))
    }

    @Test
    fun testSameTime() {
        assertEquals(0, Solution().numberOfRounds("12:00", "12:00"))
    }
}
