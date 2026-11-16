package buttonwithlongestpushtime

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ButtonWithLongestPushTimeTest {
    @Test
    fun leetCodeExample() {
        val events = arrayOf(intArrayOf(1, 2), intArrayOf(2, 5), intArrayOf(3, 9), intArrayOf(1, 15))
        assertEquals(1, Solution().buttonWithLongestTime(events))
    }

    @Test
    fun tiesSelectSmallestButtonIndex() {
        val events = arrayOf(intArrayOf(2, 4), intArrayOf(1, 8))
        assertEquals(1, Solution().buttonWithLongestTime(events))
    }

    @Test
    fun firstPushCanBeLongest() {
        val events = arrayOf(intArrayOf(3, 10), intArrayOf(1, 12))
        assertEquals(3, Solution().buttonWithLongestTime(events))
    }
}
