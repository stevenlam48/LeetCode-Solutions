package canyoueatyourfavoritecandyonyourfavoriteday

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CanYouEatYourFavoriteCandyOnYourFavoriteDayTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val candiesCount = intArrayOf(7, 4, 5, 3, 8)
        val queries = arrayOf(
            intArrayOf(0, 2, 2),
            intArrayOf(4, 2, 4),
            intArrayOf(2, 13, 1000000000)
        )
        assertEquals(listOf(true, false, true), solution.canEat(candiesCount, queries))
    }

    @Test
    fun testExample2() {
        val candiesCount = intArrayOf(5, 2, 6, 4, 1)
        val queries = arrayOf(
            intArrayOf(3, 1, 2),
            intArrayOf(4, 10, 3),
            intArrayOf(3, 10, 100),
            intArrayOf(4, 100, 30),
            intArrayOf(0, 3, 1)
        )
        assertEquals(listOf(false, true, true, false, true), solution.canEat(candiesCount, queries))
    }

    @Test
    fun testSingleType() {
        val candiesCount = intArrayOf(10)
        val queries = arrayOf(intArrayOf(0, 0, 1), intArrayOf(0, 9, 1), intArrayOf(0, 10, 1))
        assertEquals(listOf(true, true, false), solution.canEat(candiesCount, queries))
    }

    @Test
    fun testNoQueries() {
        assertEquals(emptyList<Boolean>(), solution.canEat(intArrayOf(1, 2), emptyArray()))
    }
}
