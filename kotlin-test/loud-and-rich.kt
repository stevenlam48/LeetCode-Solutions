package loudandrich

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class LoudAndRichTest {
    private val solution = Solution()

    @Test
    fun testExampleOne() {
        val richer = arrayOf(
            intArrayOf(1, 0), intArrayOf(2, 1), intArrayOf(3, 1),
            intArrayOf(3, 7), intArrayOf(4, 3), intArrayOf(5, 3), intArrayOf(6, 3)
        )
        assertArrayEquals(
            intArrayOf(5, 5, 2, 5, 4, 5, 6, 7),
            solution.loudAndRich(richer, intArrayOf(3, 2, 5, 4, 6, 1, 7, 0))
        )
    }

    @Test
    fun testExampleTwo() {
        val richer = arrayOf(intArrayOf(0, 1))
        assertArrayEquals(
            intArrayOf(0, 1),
            solution.loudAndRich(richer, intArrayOf(1, 0))
        )
    }

    @Test
    fun testSinglePerson() {
        assertArrayEquals(
            intArrayOf(0),
            solution.loudAndRich(arrayOf(), intArrayOf(0))
        )
    }

    @Test
    fun testNoRicherRelations() {
        assertArrayEquals(
            intArrayOf(0, 1, 2),
            solution.loudAndRich(arrayOf(), intArrayOf(5, 3, 9))
        )
    }

    @Test
    fun testChainOfRicherPeople() {
        val richer = arrayOf(intArrayOf(1, 0), intArrayOf(2, 1))
        assertArrayEquals(
            intArrayOf(2, 2, 2),
            solution.loudAndRich(richer, intArrayOf(9, 8, 7))
        )
    }
}
