package numberofshipsinarectangle

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

private class FakeSea(private val ships: List<IntArray>) : Sea {
    override fun hasShips(topRight: IntArray, bottomLeft: IntArray): Boolean {
        return ships.any {
            it[0] in bottomLeft[0]..topRight[0] && it[1] in bottomLeft[1]..topRight[1]
        }
    }
}

class NumberOfShipsInARectangleTest {
    @Test
    fun testMultipleShips() {
        val ships = listOf(intArrayOf(1, 1), intArrayOf(2, 2), intArrayOf(3, 3))
        assertEquals(
            3,
            Solution().countShips(FakeSea(ships), intArrayOf(4, 4), intArrayOf(1, 1))
        )
    }

    @Test
    fun testSingleShip() {
        val ships = listOf(intArrayOf(4, 4))
        assertEquals(
            1,
            Solution().countShips(FakeSea(ships), intArrayOf(4, 4), intArrayOf(1, 1))
        )
    }

    @Test
    fun testNoShips() {
        assertEquals(
            0,
            Solution().countShips(FakeSea(listOf()), intArrayOf(4, 4), intArrayOf(1, 1))
        )
    }

    @Test
    fun testShipOutsideRectangle() {
        val ships = listOf(intArrayOf(5, 5))
        assertEquals(
            0,
            Solution().countShips(FakeSea(ships), intArrayOf(4, 4), intArrayOf(1, 1))
        )
    }
}
