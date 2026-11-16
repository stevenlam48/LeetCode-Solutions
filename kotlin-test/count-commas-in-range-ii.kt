package countcommasinrangeii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountCommasInRangeIITest {
    @Test
    fun smallBounds() {
        assertEquals(0L, Solution().countCommas(999))
        assertEquals(1L, Solution().countCommas(1000))
    }

    @Test
    fun twoCommasPerNumber() {
        assertEquals(999_000L, Solution().countCommas(999_999))
        assertEquals(999_002L, Solution().countCommas(1_000_000))
    }

    @Test
    fun largeBound() {
        assertEquals(1_998_999_003L, Solution().countCommas(1_000_000_000))
    }
}
