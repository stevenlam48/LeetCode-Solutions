package shortestimpossiblesequenceofrolls

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ShortestImpossibleSequenceOfRollsTest {
    @Test
    fun countsCompleteBlocksOfAllValues() {
        assertEquals(3, Solution().shortestSequence(intArrayOf(4, 2, 1, 2, 3, 3, 2, 4, 1), 4))
    }

    @Test
    fun returnsOneWhenOnlyOneValueAppears() {
        assertEquals(1, Solution().shortestSequence(intArrayOf(1, 1, 1, 1), 2))
    }

    @Test
    fun returnsTwoWhenOneBlockIsComplete() {
        assertEquals(2, Solution().shortestSequence(intArrayOf(1, 2, 3), 3))
    }

    @Test
    fun countsRepeatedCompleteBlocks() {
        assertEquals(3, Solution().shortestSequence(intArrayOf(1, 2, 1, 2), 2))
    }

    @Test
    fun handlesLargerK() {
        assertEquals(2, Solution().shortestSequence(intArrayOf(1, 2, 3, 4, 5), 5))
        assertEquals(1, Solution().shortestSequence(intArrayOf(1, 2, 3, 4), 5))
    }
}
