package sequentiallyordinalranktracker

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SequentiallyOrdinalRankTrackerTest {
    @Test
    fun exampleSequence() {
        val tracker = SORTracker()
        tracker.add("bradford", 2)
        tracker.add("branford", 3)
        tracker.add("brad", 1)
        assertEquals("branford", tracker.get())
        tracker.add("bradley", 2)
        assertEquals("bradford", tracker.get())
        assertEquals("bradley", tracker.get())
        assertEquals("brad", tracker.get())
    }

    @Test
    fun tieBreaksBySmallerName() {
        val tracker = SORTracker()
        tracker.add("b", 5)
        tracker.add("a", 5)
        assertEquals("a", tracker.get())
        assertEquals("b", tracker.get())
    }

    @Test
    fun singleLocation() {
        val tracker = SORTracker()
        tracker.add("x", 10)
        assertEquals("x", tracker.get())
    }

    @Test
    fun betterLocationAddedBetweenGets() {
        val tracker = SORTracker()
        tracker.add("a", 1)
        tracker.add("b", 2)
        assertEquals("b", tracker.get())
        tracker.add("c", 3)
        assertEquals("b", tracker.get())
        assertEquals("a", tracker.get())
    }
}
