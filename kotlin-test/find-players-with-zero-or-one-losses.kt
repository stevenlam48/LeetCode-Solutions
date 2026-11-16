package findplayerswithzerooronelosses

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindPlayersWithZeroOrOneLossesTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        val matches = arrayOf(
            intArrayOf(1, 3), intArrayOf(2, 3), intArrayOf(3, 6), intArrayOf(5, 6),
            intArrayOf(5, 7), intArrayOf(4, 5), intArrayOf(4, 8), intArrayOf(4, 9),
            intArrayOf(10, 4), intArrayOf(10, 9)
        )
        val result = solution.findWinners(matches)
        assertArrayEquals(intArrayOf(1, 2, 10), result[0])
        assertArrayEquals(intArrayOf(4, 5, 7, 8), result[1])
    }

    @Test
    fun exampleTwo() {
        val matches = arrayOf(intArrayOf(2, 3), intArrayOf(1, 3), intArrayOf(5, 4), intArrayOf(6, 4))
        val result = solution.findWinners(matches)
        assertArrayEquals(intArrayOf(1, 2, 5, 6), result[0])
        assertArrayEquals(intArrayOf(), result[1])
    }

    @Test
    fun repeatedLossesAndNegativeIds() {
        val matches = arrayOf(intArrayOf(-1, 2), intArrayOf(3, 2), intArrayOf(2, 4), intArrayOf(5, 2))
        val result = solution.findWinners(matches)
        assertArrayEquals(intArrayOf(-1, 3, 5), result[0])
        assertArrayEquals(intArrayOf(4), result[1])
    }

    @Test
    fun emptyInput() {
        val result = solution.findWinners(arrayOf())
        assertArrayEquals(intArrayOf(), result[0])
        assertArrayEquals(intArrayOf(), result[1])
    }
}
