package bookingconcertticketsingroups

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class BookingConcertTicketsInGroupsTest {
    @Test
    fun example1() {
        val show = BookMyShow(2, 5)
        assertArrayEquals(intArrayOf(0, 0), show.gather(4, 0))
        assertArrayEquals(intArrayOf(1, 0), show.gather(4, 1))
        assertFalse(show.scatter(5, 1))
        assertFalse(show.scatter(5, 1))
    }

    @Test
    fun gatherFailsWhenRowFull() {
        val show = BookMyShow(1, 3)
        assertArrayEquals(intArrayOf(0, 0), show.gather(2, 0))
        assertArrayEquals(IntArray(0), show.gather(2, 0))
    }

    @Test
    fun scatterAcrossRows() {
        val show = BookMyShow(2, 2)
        assertTrue(show.scatter(3, 1))
        assertFalse(show.scatter(2, 1))
    }

    @Test
    fun gatherRespectsMaxRow() {
        val show = BookMyShow(2, 5)
        assertArrayEquals(intArrayOf(0, 0), show.gather(5, 0))
        assertArrayEquals(IntArray(0), show.gather(1, 0))
        assertArrayEquals(intArrayOf(1, 0), show.gather(1, 1))
    }

    @Test
    fun scatterSingleSeat() {
        val show = BookMyShow(1, 3)
        assertArrayEquals(intArrayOf(0, 0), show.gather(2, 0))
        assertTrue(show.scatter(1, 0))
        assertFalse(show.scatter(1, 0))
    }
}
