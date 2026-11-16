package findmedianfromdatastream

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMedianFromDataStreamTest {
    @Test
    fun exampleSequence() {
        val mf = MedianFinder()
        mf.addNum(1)
        mf.addNum(2)
        assertEquals(1.5, mf.findMedian())
        mf.addNum(3)
        assertEquals(2.0, mf.findMedian())
    }

    @Test
    fun longerSequence() {
        val mf = MedianFinder()
        mf.addNum(1)
        mf.addNum(2)
        mf.addNum(3)
        mf.addNum(4)
        mf.addNum(5)
        assertEquals(3.0, mf.findMedian())
        mf.addNum(6)
        assertEquals(3.5, mf.findMedian())
    }

    @Test
    fun singleElement() {
        val mf = MedianFinder()
        mf.addNum(5)
        assertEquals(5.0, mf.findMedian())
    }

    @Test
    fun negatives() {
        val mf = MedianFinder()
        mf.addNum(-1)
        mf.addNum(-2)
        assertEquals(-1.5, mf.findMedian())
        mf.addNum(-3)
        assertEquals(-2.0, mf.findMedian())
    }

    @Test
    fun duplicates() {
        val mf = MedianFinder()
        mf.addNum(2)
        mf.addNum(2)
        assertEquals(2.0, mf.findMedian())
        mf.addNum(2)
        assertEquals(2.0, mf.findMedian())
    }

    @Test
    fun descendingInput() {
        val mf = MedianFinder()
        mf.addNum(10)
        mf.addNum(9)
        mf.addNum(8)
        mf.addNum(7)
        assertEquals(8.5, mf.findMedian())
    }
}
