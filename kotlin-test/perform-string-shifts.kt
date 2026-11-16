package performstringshifts

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PerformStringShiftsTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val shift = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertEquals("cab", solution.stringShift("abc", shift))
    }

    @Test
    fun testExample2() {
        val shift = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1),
            intArrayOf(0, 2),
            intArrayOf(1, 3)
        )
        assertEquals("efgabcd", solution.stringShift("abcdefg", shift))
    }

    @Test
    fun testNoShift() {
        val shift = arrayOf(intArrayOf(0, 0))
        assertEquals("abc", solution.stringShift("abc", shift))
    }

    @Test
    fun testFullRotation() {
        val shift = arrayOf(intArrayOf(0, 3))
        assertEquals("abc", solution.stringShift("abc", shift))
    }
}
