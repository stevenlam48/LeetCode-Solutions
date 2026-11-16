package designbusseatbookingsystem

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class DesignBusSeatBookingSystemTest {
    @Test
    fun toggleSeatOnAndOff() {
        val booking = BusBooking(10)
        assertEquals(0, booking.getTotalTime())
        assertEquals(0, booking.getMinTime())
        booking.toggle("A1")
        assertEquals(1, booking.getTotalTime())
        assertEquals(1, booking.getMinTime())
        booking.toggle("A1")
        assertEquals(0, booking.getTotalTime())
        assertEquals(0, booking.getMinTime())
    }

    @Test
    fun outerSeatNextToBookedInnerSeatCostsThree() {
        val booking = BusBooking(10)
        booking.toggle("B3")
        booking.toggle("A3")
        assertEquals(4, booking.getTotalTime())
        assertEquals(2, booking.getMinTime())
        booking.toggle("C5")
        booking.toggle("D5")
        assertEquals(8, booking.getTotalTime())
        assertEquals(4, booking.getMinTime())
    }

    @Test
    fun innerSeatDoesNotReceiveOuterSeatPenalty() {
        val booking = BusBooking(10)
        booking.toggle("A2")
        booking.toggle("B2")
        booking.toggle("D2")
        booking.toggle("C2")
        assertEquals(4, booking.getTotalTime())
        assertEquals(4, booking.getMinTime())
    }

    @Test
    fun removingSeatsSubtractsTheirStoredCosts() {
        val booking = BusBooking(10)
        booking.toggle("B1")
        booking.toggle("A1")
        booking.toggle("C1")
        booking.toggle("D1")
        booking.toggle("A1")
        assertEquals(5, booking.getTotalTime())
        assertEquals(3, booking.getMinTime())
        booking.toggle("B1")
        assertEquals(4, booking.getTotalTime())
        assertEquals(2, booking.getMinTime())
    }
}
