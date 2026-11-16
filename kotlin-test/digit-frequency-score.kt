package digitfrequencyscore

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DigitFrequencyScoreTest {
    @Test
    fun testExample1() {
        assertEquals(10, Solution().digitFrequencyScore(1234))
    }

    @Test
    fun testExample2() {
        assertEquals(0, Solution().digitFrequencyScore(0))
    }

    @Test
    fun testRepeatedDigits() {
        assertEquals(2, Solution().digitFrequencyScore(11))
        assertEquals(3, Solution().digitFrequencyScore(111))
    }

    @Test
    fun testSingleDigit() {
        assertEquals(7, Solution().digitFrequencyScore(7))
        assertEquals(9, Solution().digitFrequencyScore(9))
    }

    @Test
    fun testMixed() {
        assertEquals(1 + 2 + 2 + 3, Solution().digitFrequencyScore(1223))
    }
}
