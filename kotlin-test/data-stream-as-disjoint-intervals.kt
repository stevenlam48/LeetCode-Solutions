package datastreamasdisjointintervals

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DataStreamAsDisjointIntervalsTest {
    private fun rangesOf(sr: SummaryRanges): List<String> {
        return sr.getIntervals().map { "${it.start},${it.end}" }
    }

    @Test
    fun leetcodeExample() {
        val sr = SummaryRanges()
        sr.addNum(1)
        assertEquals(listOf("1,1"), rangesOf(sr))
        sr.addNum(3)
        assertEquals(listOf("1,1", "3,3"), rangesOf(sr))
        sr.addNum(7)
        assertEquals(listOf("1,1", "3,3", "7,7"), rangesOf(sr))
        sr.addNum(2)
        assertEquals(listOf("1,3", "7,7"), rangesOf(sr))
        sr.addNum(6)
        assertEquals(listOf("1,3", "6,7"), rangesOf(sr))
    }

    @Test
    fun emptyInitially() {
        assertEquals(emptyList<String>(), rangesOf(SummaryRanges()))
    }

    @Test
    fun mergeAll() {
        val sr = SummaryRanges()
        sr.addNum(1)
        sr.addNum(9)
        sr.addNum(8)
        sr.addNum(3)
        sr.addNum(2)
        assertEquals(listOf("1,3", "8,9"), rangesOf(sr))
        sr.addNum(4)
        sr.addNum(5)
        sr.addNum(6)
        sr.addNum(7)
        assertEquals(listOf("1,9"), rangesOf(sr))
    }

    @Test
    fun duplicates() {
        val sr = SummaryRanges()
        sr.addNum(1)
        sr.addNum(1)
        sr.addNum(1)
        assertEquals(listOf("1,1"), rangesOf(sr))
    }

    @Test
    fun negativeValues() {
        val sr = SummaryRanges()
        sr.addNum(-1)
        sr.addNum(-3)
        sr.addNum(-2)
        assertEquals(listOf("-3,-1"), rangesOf(sr))
    }

    @Test
    fun bridgeTwoIntervals() {
        val sr = SummaryRanges()
        sr.addNum(1)
        sr.addNum(5)
        assertEquals(listOf("1,1", "5,5"), rangesOf(sr))
        sr.addNum(3)
        assertEquals(listOf("1,1", "3,3", "5,5"), rangesOf(sr))
        sr.addNum(4)
        assertEquals(listOf("1,1", "3,5"), rangesOf(sr))
        sr.addNum(2)
        assertEquals(listOf("1,5"), rangesOf(sr))
    }
}
