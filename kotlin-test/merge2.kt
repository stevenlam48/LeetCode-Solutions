package merge2

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Merge2Test {
    private fun render(intervals: List<Interval>): String =
        intervals.joinToString(",") { "${it.start}-${it.end}" }

    private fun intervals(vararg pairs: Pair<Int, Int>): MutableList<Interval> =
        pairs.map { Interval(it.first, it.second) }.toMutableList()

    @Test
    fun example1() {
        val input = intervals(1 to 3, 2 to 6, 8 to 10, 15 to 18)
        assertEquals("1-6,8-10,15-18", render(Solution().merge(input)))
    }

    @Test
    fun touchingIntervals() {
        val input = intervals(1 to 4, 4 to 5)
        assertEquals("1-5", render(Solution().merge(input)))
    }

    @Test
    fun unsortedContained() {
        val input = intervals(1 to 4, 0 to 4)
        assertEquals("0-4", render(Solution().merge(input)))
    }

    @Test
    fun containedInterval() {
        val input = intervals(1 to 10, 2 to 3, 4 to 5)
        assertEquals("1-10", render(Solution().merge(input)))
    }

    @Test
    fun singleInterval() {
        val input = intervals(5 to 7)
        assertEquals("5-7", render(Solution().merge(input)))
    }
}
