package designexamscorestracker

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DesignExamScoresTrackerTest {
    @Test
    fun sumsInclusiveTimeRange() {
        val tracker = ExamTracker()
        tracker.record(1, 10)
        tracker.record(3, 20)
        tracker.record(5, 30)
        tracker.record(8, 40)
        assertEquals(50L, tracker.totalScore(3, 5))
        assertEquals(100L, tracker.totalScore(1, 8))
    }

    @Test
    fun rangeWithoutExactRecordedEndpoints() {
        val tracker = ExamTracker()
        tracker.record(2, 7)
        tracker.record(4, 11)
        tracker.record(7, 13)
        assertEquals(11L, tracker.totalScore(3, 6))
        assertEquals(0L, tracker.totalScore(5, 6))
        assertEquals(0L, tracker.totalScore(8, 10))
    }

    @Test
    fun usesLongForPrefixSums() {
        val tracker = ExamTracker()
        tracker.record(1, Int.MAX_VALUE)
        tracker.record(2, Int.MAX_VALUE)
        assertEquals(2L * Int.MAX_VALUE, tracker.totalScore(1, 2))
    }

    @Test
    fun singleRecordAndNegativeScores() {
        val tracker = ExamTracker()
        tracker.record(10, -25)
        assertEquals(-25L, tracker.totalScore(10, 10))
        tracker.record(20, 5)
        assertEquals(-20L, tracker.totalScore(0, 30))
    }
}
