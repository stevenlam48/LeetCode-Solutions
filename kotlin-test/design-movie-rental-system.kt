package designmovierentalsystem

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DesignMovieRentalSystemTest {
    @Test
    fun testExample() {
        val system = MovieRentingSystem(
            3,
            arrayOf(
                intArrayOf(0, 1, 5),
                intArrayOf(0, 2, 6),
                intArrayOf(0, 3, 7),
                intArrayOf(1, 1, 4),
                intArrayOf(1, 2, 7)
            )
        )
        assertArrayEquals(intArrayOf(1, 0), system.search(1))
        system.rent(0, 1)
        assertArrayEquals(intArrayOf(1), system.search(1))
        assertArrayEquals(arrayOf(intArrayOf(0, 1)), system.report())
        system.drop(0, 1)
        assertArrayEquals(intArrayOf(1, 0), system.search(1))
    }

    @Test
    fun testSearchOrdersByPriceThenShop() {
        val system = MovieRentingSystem(
            3,
            arrayOf(
                intArrayOf(2, 1, 3),
                intArrayOf(1, 1, 3),
                intArrayOf(0, 1, 9)
            )
        )
        assertArrayEquals(intArrayOf(1, 2, 0), system.search(1))
    }

    @Test
    fun testSearchLimitsToFive() {
        val entries = Array(7) { intArrayOf(it, 1, it + 1) }
        val system = MovieRentingSystem(7, entries)
        assertArrayEquals(intArrayOf(0, 1, 2, 3, 4), system.search(1))
    }

    @Test
    fun testReportOrdersByPriceThenShopThenMovie() {
        val system = MovieRentingSystem(
            3,
            arrayOf(
                intArrayOf(0, 1, 5),
                intArrayOf(1, 2, 5),
                intArrayOf(1, 1, 5),
                intArrayOf(2, 2, 6)
            )
        )
        system.rent(0, 1)
        system.rent(2, 2)
        system.rent(1, 1)
        assertArrayEquals(
            arrayOf(intArrayOf(0, 1), intArrayOf(1, 1), intArrayOf(2, 2)),
            system.report()
        )
    }

    @Test
    fun testSearchUnknownMovie() {
        val system = MovieRentingSystem(1, arrayOf(intArrayOf(0, 1, 5)))
        assertArrayEquals(intArrayOf(), system.search(2))
        assertArrayEquals(arrayOf(), system.report())
    }
}
