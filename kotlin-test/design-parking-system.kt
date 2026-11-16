package designparkingsystem

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DesignParkingSystemTest {
    @Test
    fun testExample() {
        val system = ParkingSystem(1, 1, 0)
        assertTrue(system.addCar(1))
        assertTrue(system.addCar(2))
        assertFalse(system.addCar(3))
        assertFalse(system.addCar(1))
    }

    @Test
    fun testEachTypeIndependent() {
        val system = ParkingSystem(2, 3, 1)
        assertTrue(system.addCar(1))
        assertTrue(system.addCar(1))
        assertFalse(system.addCar(1))
        assertTrue(system.addCar(2))
        assertTrue(system.addCar(2))
        assertTrue(system.addCar(2))
        assertFalse(system.addCar(2))
        assertTrue(system.addCar(3))
        assertFalse(system.addCar(3))
    }

    @Test
    fun testNoSpaces() {
        val system = ParkingSystem(0, 0, 0)
        assertFalse(system.addCar(1))
        assertFalse(system.addCar(2))
        assertFalse(system.addCar(3))
    }
}
