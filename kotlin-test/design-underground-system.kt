package designundergroundsystem

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DesignUndergroundSystemTest {
    @Test
    fun testExample() {
        val system = UndergroundSystem()
        system.checkIn(45, "Leyton", 3)
        system.checkIn(32, "Paradise", 8)
        system.checkIn(27, "Leyton", 10)
        system.checkOut(45, "Waterloo", 15)
        system.checkOut(27, "Waterloo", 20)
        system.checkOut(32, "Cambridge", 22)
        assertEquals(14.0, system.getAverageTime("Paradise", "Cambridge"))
        assertEquals(11.0, system.getAverageTime("Leyton", "Waterloo"))
    }

    @Test
    fun testAveragesMultipleTrips() {
        val system = UndergroundSystem()
        system.checkIn(1, "A", 0)
        system.checkOut(1, "B", 10)
        system.checkIn(2, "A", 5)
        system.checkOut(2, "B", 25)
        assertEquals(15.0, system.getAverageTime("A", "B"))
    }

    @Test
    fun testSameStationTrip() {
        val system = UndergroundSystem()
        system.checkIn(1, "X", 1)
        system.checkOut(1, "X", 6)
        assertEquals(5.0, system.getAverageTime("X", "X"))
    }

    @Test
    fun testDifferentRoutesIndependent() {
        val system = UndergroundSystem()
        system.checkIn(1, "A", 0)
        system.checkOut(1, "B", 4)
        system.checkIn(2, "A", 0)
        system.checkOut(2, "C", 20)
        assertEquals(4.0, system.getAverageTime("A", "B"))
        assertEquals(20.0, system.getAverageTime("A", "C"))
    }

    @Test
    fun testRiderCanCheckInAgain() {
        val system = UndergroundSystem()
        system.checkIn(1, "A", 0)
        system.checkOut(1, "B", 2)
        system.checkIn(1, "A", 10)
        system.checkOut(1, "B", 16)
        assertEquals(4.0, system.getAverageTime("A", "B"))
    }
}
