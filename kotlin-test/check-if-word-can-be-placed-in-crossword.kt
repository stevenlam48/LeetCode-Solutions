package checkifwordcanbeplacedincrossword

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CheckIfWordCanBePlacedInCrosswordTest {
    private val solution = Solution()

    @Test
    fun testHorizontalSlot() {
        val board = arrayOf(
            charArrayOf('#', ' ', '#'),
            charArrayOf(' ', ' ', '#'),
            charArrayOf('#', ' ', '#')
        )
        assertTrue(solution.placeWordInCrossword(board, "abc"))
    }

    @Test
    fun testSingleRowSlot() {
        assertTrue(solution.placeWordInCrossword(arrayOf(charArrayOf(' ', ' ')), "ab"))
    }

    @Test
    fun testFilledSlot() {
        assertTrue(solution.placeWordInCrossword(arrayOf(charArrayOf('a', 'b')), "ab"))
    }

    @Test
    fun testReversedFilledSlot() {
        assertTrue(solution.placeWordInCrossword(arrayOf(charArrayOf('a', 'b')), "ba"))
    }

    @Test
    fun testWrongLength() {
        assertFalse(solution.placeWordInCrossword(arrayOf(charArrayOf('a', 'b', 'c')), "ab"))
    }

    @Test
    fun testVerticalSlot() {
        val board = arrayOf(
            charArrayOf('a'),
            charArrayOf('b')
        )
        assertTrue(solution.placeWordInCrossword(board, "ab"))
    }
}
