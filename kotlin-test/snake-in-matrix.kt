package snakeinmatrix

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SnakeInMatrixTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().finalPositionOfSnake(2, listOf("RIGHT", "DOWN")))
    }

    @Test
    fun example2() {
        assertEquals(1, Solution().finalPositionOfSnake(3, listOf("DOWN", "RIGHT", "UP")))
    }

    @Test
    fun noCommands() {
        assertEquals(0, Solution().finalPositionOfSnake(1, emptyList()))
    }

    @Test
    fun moveRightTwiceThenDown() {
        assertEquals(5, Solution().finalPositionOfSnake(3, listOf("RIGHT", "RIGHT", "DOWN")))
    }
}
