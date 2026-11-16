package countnumberofpossiblerootnodes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountNumberOfPossibleRootNodesTest {
    @Test
    fun exampleOne() {
        val edges = arrayOf(
            intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(4, 2)
        )
        val guesses = arrayOf(
            intArrayOf(1, 3), intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(2, 4)
        )
        assertEquals(3, Solution().rootCount(edges, guesses, 3))
    }

    @Test
    fun exampleTwo() {
        val edges = arrayOf(
            intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 4)
        )
        val guesses = arrayOf(
            intArrayOf(1, 0), intArrayOf(3, 4), intArrayOf(2, 1), intArrayOf(3, 2)
        )
        assertEquals(5, Solution().rootCount(edges, guesses, 1))
    }

    @Test
    fun singleNode() {
        assertEquals(1, Solution().rootCount(emptyArray(), arrayOf(intArrayOf(0, 1)), 0))
        assertEquals(0, Solution().rootCount(emptyArray(), arrayOf(intArrayOf(0, 1)), 1))
    }

    @Test
    fun noGuessesAllowsEveryRoot() {
        val edges = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertEquals(3, Solution().rootCount(edges, emptyArray(), 0))
    }
}
