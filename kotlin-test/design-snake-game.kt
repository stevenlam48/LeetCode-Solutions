package designsnakegame

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DesignSnakeGameTest {
    @Test
    fun testExample() {
        val game = SnakeGame(
            3,
            2,
            arrayOf(intArrayOf(1, 2), intArrayOf(0, 1))
        )
        assertEquals(0, game.move("R"))
        assertEquals(0, game.move("D"))
        assertEquals(1, game.move("R"))
        assertEquals(1, game.move("U"))
        assertEquals(2, game.move("L"))
        assertEquals(-1, game.move("U"))
    }

    @Test
    fun testWallCollision() {
        val game = SnakeGame(2, 2, arrayOf())
        assertEquals(-1, game.move("U"))
    }

    @Test
    fun testSelfCollision() {
        val game = SnakeGame(
            4,
            1,
            arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3))
        )
        assertEquals(1, game.move("R"))
        assertEquals(2, game.move("R"))
        assertEquals(3, game.move("R"))
        assertEquals(-1, game.move("L"))
    }

    @Test
    fun testNoFood() {
        val game = SnakeGame(10, 10, arrayOf())
        assertEquals(0, game.move("D"))
        assertEquals(0, game.move("D"))
        assertEquals(0, game.move("R"))
        assertEquals(0, game.move("R"))
    }

    @Test
    fun testEatFirstFoodOnly() {
        val game = SnakeGame(5, 5, arrayOf(intArrayOf(0, 1)))
        assertEquals(1, game.move("R"))
        assertEquals(1, game.move("R"))
        assertEquals(1, game.move("D"))
    }
}
