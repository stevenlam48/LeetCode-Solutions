package countcommasinrange

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountCommasInRangeTest {
    @Test
    fun belowFirstGroupSeparator() {
        assertEquals(0, Solution().countCommas(0))
        assertEquals(0, Solution().countCommas(999))
    }

    @Test
    fun firstGroupSeparator() {
        assertEquals(1, Solution().countCommas(1000))
        assertEquals(2, Solution().countCommas(1001))
    }

    @Test
    fun secondGroupSeparator() {
        assertEquals(999_000, Solution().countCommas(999_999))
        assertEquals(999_002, Solution().countCommas(1_000_000))
    }
}
