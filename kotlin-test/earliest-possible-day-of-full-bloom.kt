package earliestpossibledayoffullbloom

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EarliestPossibleDayOfFullBloomTest {
    @Test
    fun example1() {
        assertEquals(9, Solution().earliestFullBloom(intArrayOf(1, 4, 3), intArrayOf(2, 3, 1)))
    }

    @Test
    fun example2() {
        assertEquals(9, Solution().earliestFullBloom(intArrayOf(1, 2, 3, 2), intArrayOf(2, 1, 2, 1)))
    }

    @Test
    fun singlePlant() {
        assertEquals(2, Solution().earliestFullBloom(intArrayOf(1), intArrayOf(1)))
    }

    @Test
    fun allSame() {
        assertEquals(4, Solution().earliestFullBloom(intArrayOf(1, 1, 1), intArrayOf(1, 1, 1)))
    }
}
