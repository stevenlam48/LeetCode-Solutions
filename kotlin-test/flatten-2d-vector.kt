package flatten2dvector

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test

class Flatten2dVectorTest {
    private fun drain(vector: Vector2D): List<Int> {
        val result = mutableListOf<Int>()
        while (vector.hasNext()) {
            result.add(vector.next())
        }
        return result
    }

    @Test
    fun example() {
        val vector = Vector2D(listOf(listOf(1, 2), listOf(3), listOf(), listOf(4, 5)))
        assertEquals(listOf(1, 2, 3, 4, 5), drain(vector))
    }

    @Test
    fun empty() {
        val vector = Vector2D(listOf())
        assertFalse(vector.hasNext())
    }

    @Test
    fun leadingEmptyRows() {
        val vector = Vector2D(listOf(listOf(), listOf(), listOf(1)))
        assertEquals(listOf(1), drain(vector))
    }

    @Test
    fun singleRow() {
        val vector = Vector2D(listOf(listOf(1, 2, 3)))
        assertEquals(listOf(1, 2, 3), drain(vector))
    }

    @Test
    fun interleavedEmptyRows() {
        val vector = Vector2D(listOf(listOf(1), listOf(), listOf(2), listOf(), listOf(3)))
        assertEquals(listOf(1, 2, 3), drain(vector))
    }
}
