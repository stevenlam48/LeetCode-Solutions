package shiftinglettersii

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShiftingLettersIiTest {
    @Test
    fun combinesForwardAndBackwardShifts() {
        val shifts = arrayOf(intArrayOf(0, 1, 0), intArrayOf(1, 2, 1), intArrayOf(0, 2, 1))
        assertEquals("ace", Solution().shiftingLetters("abc", shifts))
    }

    @Test
    fun wrapsInBothDirections() {
        val shifts = arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 1, 1))
        assertEquals("catz", Solution().shiftingLetters("dztz", shifts))
    }

    @Test
    fun handlesNoAndFullRangeShifts() {
        assertEquals("abc", Solution().shiftingLetters("abc", emptyArray()))
        assertEquals("bcd", Solution().shiftingLetters("abc", arrayOf(intArrayOf(0, 2, 1))))
    }
}
