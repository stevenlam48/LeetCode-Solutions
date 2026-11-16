package mycalendariii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MyCalendarIiiTest {
    @Test
    fun example() {
        val calendar = MyCalendarThree()
        assertEquals(1, calendar.book(10, 20))
        assertEquals(1, calendar.book(50, 60))
        assertEquals(2, calendar.book(10, 40))
        assertEquals(3, calendar.book(5, 15))
        assertEquals(3, calendar.book(5, 10))
        assertEquals(3, calendar.book(25, 55))
    }

    @Test
    fun singleBooking() {
        val calendar = MyCalendarThree()
        assertEquals(1, calendar.book(0, 1))
    }

    @Test
    fun fullyOverlapping() {
        val calendar = MyCalendarThree()
        assertEquals(1, calendar.book(10, 20))
        assertEquals(2, calendar.book(10, 20))
        assertEquals(3, calendar.book(10, 20))
    }

    @Test
    fun adjacentIntervals() {
        val calendar = MyCalendarThree()
        assertEquals(1, calendar.book(10, 20))
        assertEquals(1, calendar.book(20, 30))
        assertEquals(1, calendar.book(30, 40))
    }

    @Test
    fun nestedIntervals() {
        val calendar = MyCalendarThree()
        assertEquals(1, calendar.book(0, 100))
        assertEquals(2, calendar.book(10, 90))
        assertEquals(3, calendar.book(20, 80))
        assertEquals(4, calendar.book(30, 70))
    }
}
