package rotatingthebox

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RotatingTheBoxTest {
    @Test
    fun leetCodeExampleSingleRow() {
        val box = arrayOf(charArrayOf('#', '.', '#'))
        val expected = arrayOf(
            charArrayOf('.'),
            charArrayOf('#'),
            charArrayOf('#')
        )
        assertTrue(Solution().rotateTheBox(box).contentDeepEquals(expected))
    }

    @Test
    fun leetCodeExampleWithObstacles() {
        val box = arrayOf(
            charArrayOf('#', '.', '*', '.'),
            charArrayOf('#', '#', '*', '.')
        )
        val expected = arrayOf(
            charArrayOf('#', '.'),
            charArrayOf('#', '#'),
            charArrayOf('*', '*'),
            charArrayOf('.', '.')
        )
        assertTrue(Solution().rotateTheBox(box).contentDeepEquals(expected))
    }

    @Test
    fun stonesRestOnObstacles() {
        val box = arrayOf(charArrayOf('#', '*', '#', '.'))
        val expected = arrayOf(
            charArrayOf('#'),
            charArrayOf('*'),
            charArrayOf('.'),
            charArrayOf('#')
        )
        assertTrue(Solution().rotateTheBox(box).contentDeepEquals(expected))
    }

    @Test
    fun emptyBox() {
        val box = arrayOf(charArrayOf('.', '.', '.'))
        val expected = arrayOf(
            charArrayOf('.'),
            charArrayOf('.'),
            charArrayOf('.')
        )
        assertTrue(Solution().rotateTheBox(box).contentDeepEquals(expected))
    }
}
