package mycalendari

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class MyCalendarITest {
    @Test
    fun example() {
        val calendar = MyCalendar()
        assertTrue(calendar.book(10, 20))
        assertFalse(calendar.book(15, 25))
        assertTrue(calendar.book(20, 30))
    }

    @Test
    fun adjacentIntervals() {
        val calendar = MyCalendar()
        assertTrue(calendar.book(10, 20))
        assertTrue(calendar.book(5, 10))
        assertTrue(calendar.book(0, 5))
    }

    @Test
    fun overlappingBothSides() {
        val calendar = MyCalendar()
        assertTrue(calendar.book(10, 20))
        assertFalse(calendar.book(5, 15))
        assertFalse(calendar.book(15, 25))
        assertFalse(calendar.book(5, 25))
    }

    @Test
    fun containedInterval() {
        val calendar = MyCalendar()
        assertTrue(calendar.book(10, 20))
        assertFalse(calendar.book(12, 18))
    }

    @Test
    fun multipleBookings() {
        val calendar = MyCalendar()
        assertTrue(calendar.book(10, 20))
        assertTrue(calendar.book(20, 30))
        assertFalse(calendar.book(25, 35))
        assertTrue(calendar.book(30, 40))
    }
}
