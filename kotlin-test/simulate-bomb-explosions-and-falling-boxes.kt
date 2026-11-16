package simulatebombexplosionsandfallingboxes

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SimulateBombExplosionsAndFallingBoxesTest {
    private val solution = Solution()

    @Test
    fun `boxes fall without bombs`() {
        val grid = arrayOf(charArrayOf('#', '#'), charArrayOf('-', '-'))
        val expected = arrayOf(charArrayOf('-', '-'), charArrayOf('#', '#'))
        assertGridEquals(expected, solution.finalGrid(grid))
    }

    @Test
    fun `bomb destroys neighboring boxes`() {
        val grid = arrayOf(charArrayOf('#'), charArrayOf('*'), charArrayOf('#'))
        val expected = arrayOf(charArrayOf('-'), charArrayOf('*'), charArrayOf('-'))
        assertGridEquals(expected, solution.finalGrid(grid))
    }

    @Test
    fun `falling boxes detonate bomb repeatedly`() {
        val grid = arrayOf(charArrayOf('#'), charArrayOf('#'), charArrayOf('*'))
        val expected = arrayOf(charArrayOf('-'), charArrayOf('-'), charArrayOf('*'))
        assertGridEquals(expected, solution.finalGrid(grid))
    }

    @Test
    fun `diagonal box falls then explodes`() {
        val grid = arrayOf(charArrayOf('#', '-'), charArrayOf('-', '*'))
        val expected = arrayOf(charArrayOf('-', '-'), charArrayOf('-', '*'))
        assertGridEquals(expected, solution.finalGrid(grid))
    }

    private fun assertGridEquals(expected: Array<CharArray>, actual: Array<CharArray>) {
        assertArrayEquals(expected.map { String(it) }.toTypedArray(), actual.map { String(it) }.toTypedArray())
    }
}
