package mycalendarii

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MyCalendarIiTest {
    @Test
    fun example() {
        val calendar = MyCalendarTwo()
        assertTrue(calendar.book(10, 20))
        assertTrue(calendar.book(50, 60))
        assertTrue(calendar.book(10, 40))
        assertFalse(calendar.book(5, 15))
        assertTrue(calendar.book(5, 10))
        assertTrue(calendar.book(25, 55))
    }

    @Test
    fun tripleOverlapRejected() {
        val calendar = MyCalendarTwo()
        assertTrue(calendar.book(10, 20))
        assertTrue(calendar.book(15, 25))
        assertFalse(calendar.book(17, 22))
    }

    @Test
    fun adjacentIntervalsAllowed() {
        val calendar = MyCalendarTwo()
        assertTrue(calendar.book(10, 20))
        assertTrue(calendar.book(20, 30))
        assertTrue(calendar.book(30, 40))
    }

    @Test
    fun sameIntervalTwice() {
        val calendar = MyCalendarTwo()
        assertTrue(calendar.book(10, 20))
        assertTrue(calendar.book(10, 20))
        assertFalse(calendar.book(10, 20))
    }

    @Test
    fun disjointIntervals() {
        val calendar = MyCalendarTwo()
        assertTrue(calendar.book(0, 5))
        assertTrue(calendar.book(10, 15))
        assertTrue(calendar.book(20, 25))
    }
}
