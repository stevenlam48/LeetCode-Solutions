package missingranges

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MissingRangesTest {
    private val solution = Solution()

    @Test
    fun findsSingleAndMultiValueRanges() {
        assertEquals(
            listOf("2", "4->49", "51->74", "76->99"),
            solution.findMissingRanges(intArrayOf(0, 1, 3, 50, 75), 0, 99)
        )
    }

    @Test
    fun handlesEmptyInput() {
        assertEquals(listOf("0->1"), solution.findMissingRanges(intArrayOf(), 0, 1))
    }

    @Test
    fun handlesIntegerBoundsWithoutOverflow() {
        assertEquals(
            listOf("-2147483647->2147483647"),
            solution.findMissingRanges(intArrayOf(Int.MIN_VALUE), Int.MIN_VALUE, Int.MAX_VALUE)
        )
    }

    @Test
    fun returnsEmptyWhenRangeIsCovered() {
        assertEquals(emptyList<String>(), solution.findMissingRanges(intArrayOf(1, 2, 3), 1, 3))
    }
}
