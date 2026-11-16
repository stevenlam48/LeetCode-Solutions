package filterrestaurantsbyveganfriendlypriceanddistance

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FilterRestaurantsByVeganFriendlyPriceAndDistanceTest {
    private val restaurants = arrayOf(
        intArrayOf(1, 4, 1, 40, 10),
        intArrayOf(2, 8, 0, 50, 5),
        intArrayOf(3, 8, 1, 30, 4),
        intArrayOf(4, 10, 0, 40, 3),
        intArrayOf(5, 1, 1, 20, 5)
    )

    @Test
    fun example1() {
        assertEquals(listOf(3, 1, 5), Solution().filterRestaurants(restaurants, 1, 50, 10))
    }

    @Test
    fun example2() {
        assertEquals(listOf(4, 3, 2, 1, 5), Solution().filterRestaurants(restaurants, 0, 50, 10))
    }

    @Test
    fun noRestaurantMatches() {
        assertEquals(emptyList<Int>(), Solution().filterRestaurants(restaurants, 1, 10, 1))
    }

    @Test
    fun tiesBrokenByIdDescending() {
        val input = arrayOf(
            intArrayOf(1, 5, 1, 10, 10),
            intArrayOf(2, 5, 1, 10, 10)
        )
        assertEquals(listOf(2, 1), Solution().filterRestaurants(input, 1, 10, 10))
    }

    @Test
    fun emptyInput() {
        assertEquals(emptyList<Int>(), Solution().filterRestaurants(emptyArray(), 1, 50, 10))
    }
}
