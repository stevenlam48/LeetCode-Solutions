package designanarraystatisticstracker

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DesignAnArrayStatisticsTrackerTest {
    @Test
    fun testExample() {
        val tracker = StatisticsTracker()
        tracker.addNumber(4)
        tracker.addNumber(4)
        tracker.addNumber(1)
        tracker.addNumber(5)
        tracker.addNumber(2)
        assertEquals(3, tracker.getMean())
        assertEquals(4, tracker.getMedian())
        assertEquals(4, tracker.getMode())
        tracker.removeFirstAddedNumber()
        assertEquals(3, tracker.getMean())
        assertEquals(4, tracker.getMedian())
        assertEquals(1, tracker.getMode())
    }

    @Test
    fun testSingleElement() {
        val tracker = StatisticsTracker()
        tracker.addNumber(7)
        assertEquals(7, tracker.getMean())
        assertEquals(7, tracker.getMedian())
        assertEquals(7, tracker.getMode())
    }

    @Test
    fun testMedianEvenCount() {
        val tracker = StatisticsTracker()
        tracker.addNumber(1)
        tracker.addNumber(2)
        tracker.addNumber(3)
        tracker.addNumber(4)
        assertEquals(3, tracker.getMedian())
    }

    @Test
    fun testModeTiePicksSmallest() {
        val tracker = StatisticsTracker()
        tracker.addNumber(5)
        tracker.addNumber(5)
        tracker.addNumber(3)
        tracker.addNumber(3)
        assertEquals(3, tracker.getMode())
    }

    @Test
    fun testRemoveUpdatesAll() {
        val tracker = StatisticsTracker()
        tracker.addNumber(10)
        tracker.addNumber(20)
        tracker.addNumber(30)
        tracker.removeFirstAddedNumber()
        assertEquals(25, tracker.getMean())
        assertEquals(30, tracker.getMedian())
        assertEquals(20, tracker.getMode())
    }
}
