package seatreservationmanager

// Time:  ctor:      O(n)
//        reserve:   O(logn)
//        unreserve: O(logn)
// Space: O(n)

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SeatReservationManagerTest {
    @Test
    fun exampleOperationSequence() {
        val manager = SeatManager(5)
        assertEquals(1, manager.reserve())
        assertEquals(2, manager.reserve())
        manager.unreserve(2)
        assertEquals(2, manager.reserve())
        assertEquals(3, manager.reserve())
        assertEquals(4, manager.reserve())
        assertEquals(5, manager.reserve())
    }

    @Test
    fun unreservesLowestSeat() {
        val manager = SeatManager(4)
        assertEquals(1, manager.reserve())
        assertEquals(2, manager.reserve())
        assertEquals(3, manager.reserve())
        manager.unreserve(3)
        manager.unreserve(1)
        assertEquals(1, manager.reserve())
        assertEquals(3, manager.reserve())
        assertEquals(4, manager.reserve())
    }

    @Test
    fun singleSeat() {
        val manager = SeatManager(1)
        assertEquals(1, manager.reserve())
        manager.unreserve(1)
        assertEquals(1, manager.reserve())
    }
}
