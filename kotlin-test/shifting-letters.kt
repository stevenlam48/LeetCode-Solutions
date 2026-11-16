package shiftingletters

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShiftingLettersTest {
    @Test
    fun shiftsSuffixes() {
        assertEquals("rpl", Solution().shiftingLetters("abc", intArrayOf(3, 5, 9)))
    }

    @Test
    fun handlesSequentialShifts() {
        assertEquals("gfd", Solution().shiftingLetters("aaa", intArrayOf(1, 2, 3)))
        assertEquals("abc", Solution().shiftingLetters("abc", intArrayOf(0, 0, 0)))
    }

    @Test
    fun handlesLargeShiftsWithoutOverflow() {
        assertEquals("ux", Solution().shiftingLetters("aa", intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE)))
    }
}
