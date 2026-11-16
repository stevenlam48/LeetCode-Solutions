package designafoodratingsystem

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DesignAFoodRatingSystemTest {
    @Test
    fun testExample() {
        val fr = FoodRatings(
            arrayOf("kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"),
            arrayOf("korean", "japanese", "japanese", "greek", "japanese", "korean"),
            intArrayOf(9, 12, 8, 15, 14, 7)
        )
        assertEquals("kimchi", fr.highestRated("korean"))
        assertEquals("ramen", fr.highestRated("japanese"))
        fr.changeRating("sushi", 16)
        assertEquals("sushi", fr.highestRated("japanese"))
        fr.changeRating("ramen", 16)
        assertEquals("ramen", fr.highestRated("japanese"))
    }

    @Test
    fun testTieBreaksLexicographically() {
        val fr = FoodRatings(
            arrayOf("apple", "banana", "cherry"),
            arrayOf("fruit", "fruit", "fruit"),
            intArrayOf(10, 10, 10)
        )
        assertEquals("apple", fr.highestRated("fruit"))
    }

    @Test
    fun testChangeRatingToLower() {
        val fr = FoodRatings(
            arrayOf("a", "b"),
            arrayOf("x", "x"),
            intArrayOf(5, 3)
        )
        assertEquals("a", fr.highestRated("x"))
        fr.changeRating("a", 1)
        assertEquals("b", fr.highestRated("x"))
    }

    @Test
    fun testSingleFood() {
        val fr = FoodRatings(arrayOf("only"), arrayOf("c"), intArrayOf(7))
        assertEquals("only", fr.highestRated("c"))
        fr.changeRating("only", 100)
        assertEquals("only", fr.highestRated("c"))
    }
}
