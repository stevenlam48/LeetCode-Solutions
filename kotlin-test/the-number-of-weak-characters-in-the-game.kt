package thenumberofweakcharactersinthegame

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TheNumberOfWeakCharactersInTheGameTest {

    @Test
    fun testExample1() {
        val properties = arrayOf(
            intArrayOf(5, 5),
            intArrayOf(6, 3),
            intArrayOf(3, 6)
        )
        assertEquals(0, Solution().numberOfWeakCharacters(properties))
    }

    @Test
    fun testExample2() {
        val properties = arrayOf(
            intArrayOf(2, 2),
            intArrayOf(3, 3)
        )
        assertEquals(1, Solution().numberOfWeakCharacters(properties))
    }

    @Test
    fun testExample3() {
        val properties = arrayOf(
            intArrayOf(1, 5),
            intArrayOf(10, 4),
            intArrayOf(4, 3)
        )
        assertEquals(1, Solution().numberOfWeakCharacters(properties))
    }

    @Test
    fun testSingleCharacter() {
        assertEquals(0, Solution().numberOfWeakCharacters(arrayOf(intArrayOf(1, 1))))
    }

    @Test
    fun testEqualAttack() {
        val properties = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 2),
            intArrayOf(1, 3)
        )
        assertEquals(0, Solution().numberOfWeakCharacters(properties))
    }

    @Test
    fun testAllWeak() {
        val properties = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 2),
            intArrayOf(3, 3)
        )
        assertEquals(2, Solution().numberOfWeakCharacters(properties))
    }
}
