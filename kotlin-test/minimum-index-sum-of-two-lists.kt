package minimumindexsumoftwolists

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MinimumIndexSumOfTwoListsTest {
    @Test
    fun oneCommonRestaurantHasMinimumIndexSum() {
        assertEquals(listOf("Shogun"), Solution().findRestaurant(listOf("Shogun", "Tapioca Express", "Burger King", "KFC"), listOf("Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun")))
    }

    @Test
    fun tiesReturnAllRestaurantsInSecondListOrder() {
        assertEquals(listOf("Shogun", "KFC"), Solution().findRestaurant(listOf("KFC", "Shogun"), listOf("Shogun", "KFC")))
    }

    @Test
    fun lowerIndexSumDiscardsEarlierResult() {
        assertEquals(listOf("Shogun"), Solution().findRestaurant(listOf("Shogun", "Tapioca Express", "Burger King", "KFC"), listOf("KFC", "Shogun", "Burger King")))
    }

    @Test
    fun noCommonRestaurantReturnsEmptyList() {
        assertEquals(emptyList<String>(), Solution().findRestaurant(listOf("A", "B"), listOf("C", "D")))
    }
}
