package numberofwaystobuildhouseofcards

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToBuildHouseOfCardsTest {
    @Test
    fun oneTriangle() {
        assertEquals(1, Solution().houseOfCards(2))
    }

    @Test
    fun twoTriangles() {
        assertEquals(1, Solution().houseOfCards(5))
    }

    @Test
    fun oneAndTwo() {
        assertEquals(1, Solution().houseOfCards(7))
    }

    @Test
    fun impossible() {
        assertEquals(0, Solution().houseOfCards(4))
    }

    @Test
    fun example() {
        assertEquals(2, Solution().houseOfCards(16))
    }

    @Test
    fun twoWays() {
        assertEquals(2, Solution().houseOfCards(13))
    }
}
