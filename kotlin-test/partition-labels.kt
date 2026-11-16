package partitionlabels

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class PartitionLabelsTest {
    private val solution = Solution()

    @Test
    fun partitionsIntoAsManyPartsAsPossible() {
        assertArrayEquals(
            intArrayOf(9, 7, 8),
            solution.partitionLabels("ababcbacadefegdehijhklij")
        )
    }

    @Test
    fun returnsWholeStringWhenLettersOverlap() {
        assertArrayEquals(intArrayOf(10), solution.partitionLabels("eccbbbbdec"))
    }

    @Test
    fun handlesSingleCharacter() {
        assertArrayEquals(intArrayOf(1), solution.partitionLabels("a"))
    }

    @Test
    fun separatesDistinctCharacters() {
        assertArrayEquals(intArrayOf(1, 1, 1), solution.partitionLabels("abc"))
    }
}
