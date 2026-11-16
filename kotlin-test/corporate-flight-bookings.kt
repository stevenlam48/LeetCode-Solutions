package corporateflightbookings

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class CorporateFlightBookingsTest {
    private val solution = Solution()

    @Test
    fun testExample() {
        val bookings = arrayOf(
            intArrayOf(1, 2, 10),
            intArrayOf(2, 3, 20),
            intArrayOf(2, 5, 25)
        )
        assertArrayEquals(intArrayOf(10, 55, 45, 25, 25), solution.corpFlightBookings(bookings, 5))
    }

    @Test
    fun testSingleFlight() {
        val bookings = arrayOf(intArrayOf(1, 1, 5))
        assertArrayEquals(intArrayOf(5), solution.corpFlightBookings(bookings, 1))
    }

    @Test
    fun testNoBookings() {
        assertArrayEquals(intArrayOf(0, 0, 0), solution.corpFlightBookings(arrayOf(), 3))
    }
}
