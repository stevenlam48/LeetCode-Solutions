package designridesharingsystem

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DesignRideSharingSystemTest {
    @Test
    fun testExample() {
        val system = RideSharingSystem()
        system.addRider(1)
        system.addRider(2)
        system.addDriver(10)
        system.addDriver(11)
        assertArrayEquals(intArrayOf(10, 1), system.matchDriverWithRider())
        assertArrayEquals(intArrayOf(11, 2), system.matchDriverWithRider())
        assertArrayEquals(intArrayOf(-1, -1), system.matchDriverWithRider())
    }

    @Test
    fun testCancelRider() {
        val system = RideSharingSystem()
        system.addRider(1)
        system.addRider(2)
        system.addDriver(10)
        system.cancelRider(1)
        assertArrayEquals(intArrayOf(10, 2), system.matchDriverWithRider())
        assertArrayEquals(intArrayOf(-1, -1), system.matchDriverWithRider())
    }

    @Test
    fun testNoDriversOrRiders() {
        val system = RideSharingSystem()
        assertArrayEquals(intArrayOf(-1, -1), system.matchDriverWithRider())
        system.addRider(1)
        assertArrayEquals(intArrayOf(-1, -1), system.matchDriverWithRider())
        system.addDriver(5)
        assertArrayEquals(intArrayOf(5, 1), system.matchDriverWithRider())
    }

    @Test
    fun testFifoOrderAfterReinsertion() {
        val system = RideSharingSystem()
        system.addRider(1)
        system.addRider(2)
        system.addDriver(10)
        system.addDriver(20)
        assertArrayEquals(intArrayOf(10, 1), system.matchDriverWithRider())
        system.addRider(3)
        assertArrayEquals(intArrayOf(20, 2), system.matchDriverWithRider())
        system.addDriver(30)
        assertArrayEquals(intArrayOf(30, 3), system.matchDriverWithRider())
    }

    @Test
    fun testCancelUnknownRider() {
        val system = RideSharingSystem()
        system.cancelRider(42)
        system.addRider(1)
        system.addDriver(2)
        assertArrayEquals(intArrayOf(2, 1), system.matchDriverWithRider())
    }
}
