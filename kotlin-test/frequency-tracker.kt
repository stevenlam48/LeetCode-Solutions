package frequencytracker

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class FrequencyTrackerTest {
    @Test
    fun `standard operation sequence`() {
        val tracker = FrequencyTracker()

        tracker.add(3)
        tracker.add(3)

        assertTrue(tracker.hasFrequency(2))
        assertFalse(tracker.hasFrequency(1))
    }

    @Test
    fun `deletions update every affected frequency`() {
        val tracker = FrequencyTracker()
        tracker.add(1)
        tracker.add(1)
        tracker.add(2)
        assertTrue(tracker.hasFrequency(2))
        assertTrue(tracker.hasFrequency(1))

        tracker.deleteOne(1)
        assertFalse(tracker.hasFrequency(2))
        assertTrue(tracker.hasFrequency(1))

        tracker.deleteOne(1)
        assertTrue(tracker.hasFrequency(1))
        tracker.deleteOne(2)
        assertFalse(tracker.hasFrequency(1))
        assertFalse(tracker.hasFrequency(2))
    }

    @Test
    fun `deleting an absent number changes nothing`() {
        val tracker = FrequencyTracker()

        tracker.deleteOne(9)
        assertFalse(tracker.hasFrequency(1))
        tracker.add(4)
        tracker.deleteOne(9)
        assertTrue(tracker.hasFrequency(1))
        tracker.deleteOne(4)
        tracker.deleteOne(4)
        assertFalse(tracker.hasFrequency(1))
    }

    @Test
    fun `numbers are tracked independently`() {
        val tracker = FrequencyTracker()
        tracker.add(-1)
        tracker.add(-1)
        tracker.add(0)
        tracker.add(0)
        tracker.add(0)
        tracker.add(7)

        assertTrue(tracker.hasFrequency(1))
        assertTrue(tracker.hasFrequency(2))
        assertTrue(tracker.hasFrequency(3))

        tracker.deleteOne(0)
        assertFalse(tracker.hasFrequency(3))
        assertTrue(tracker.hasFrequency(2))
        tracker.deleteOne(-1)
        tracker.deleteOne(-1)
        tracker.deleteOne(0)
        assertFalse(tracker.hasFrequency(2))
        assertTrue(tracker.hasFrequency(1))
    }
}
