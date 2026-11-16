package kemptyslots

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KEmptySlotsTest {
    @Test
    fun `finds earliest valid blooming day`() {
        assertEquals(2, Solution().kEmptySlots(intArrayOf(1, 3, 2), 1))
    }

    @Test
    fun `returns minus one when no valid pair exists`() {
        assertEquals(-1, Solution().kEmptySlots(intArrayOf(1, 2, 3), 1))
    }

    @Test
    fun `chooses earlier of multiple windows`() {
        assertEquals(2, Solution().kEmptySlots(intArrayOf(3, 1, 5, 4, 2), 1))
    }

    @Test
    fun `zero gaps means adjacent flowers`() {
        assertEquals(3, Solution().kEmptySlots(intArrayOf(3, 1, 2), 0))
    }
}
