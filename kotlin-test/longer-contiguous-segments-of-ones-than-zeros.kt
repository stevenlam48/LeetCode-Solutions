package longercontiguoussegmentsofonesthanzeros

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LongerContiguousSegmentsOfOnesThanZerosTest {
    @Test
    fun onesLonger() {
        assertTrue(Solution().checkZeroOnes("1101"))
    }

    @Test
    fun zerosLonger() {
        assertFalse(Solution().checkZeroOnes("111000"))
    }

    @Test
    fun mixedSegments() {
        assertFalse(Solution().checkZeroOnes("110100010"))
    }

    @Test
    fun singleOne() {
        assertTrue(Solution().checkZeroOnes("1"))
    }

    @Test
    fun singleZero() {
        assertFalse(Solution().checkZeroOnes("0"))
    }

    @Test
    fun equalSegments() {
        assertFalse(Solution().checkZeroOnes("111000"))
        assertFalse(Solution().checkZeroOnes("1100"))
    }
}
