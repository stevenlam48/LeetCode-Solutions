package sequencereconstruction

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SequenceReconstructionTest {
    @Test
    fun exampleMissingPair() {
        assertFalse(
            Solution().sequenceReconstruction(
                intArrayOf(1, 2, 3),
                arrayOf(intArrayOf(1, 2), intArrayOf(1, 3)),
            ),
        )
    }

    @Test
    fun exampleIncompleteSequence() {
        assertFalse(
            Solution().sequenceReconstruction(intArrayOf(1, 2, 3), arrayOf(intArrayOf(1, 2))),
        )
    }

    @Test
    fun exampleAllPairs() {
        assertTrue(
            Solution().sequenceReconstruction(
                intArrayOf(1, 2, 3),
                arrayOf(intArrayOf(1, 2), intArrayOf(1, 3), intArrayOf(2, 3)),
            ),
        )
    }

    @Test
    fun exampleLongerSequence() {
        assertTrue(
            Solution().sequenceReconstruction(
                intArrayOf(4, 1, 5, 2, 6, 3),
                arrayOf(intArrayOf(5, 2, 6, 3), intArrayOf(4, 1, 5, 2)),
            ),
        )
    }

    @Test
    fun emptySeqs() {
        assertFalse(Solution().sequenceReconstruction(intArrayOf(1), emptyArray()))
    }

    @Test
    fun outOfRangeValue() {
        assertFalse(Solution().sequenceReconstruction(intArrayOf(1), arrayOf(intArrayOf(2))))
    }

    @Test
    fun singleElementOrg() {
        assertTrue(Solution().sequenceReconstruction(intArrayOf(1), arrayOf(intArrayOf(1))))
    }

    @Test
    fun descendingPairIsInvalid() {
        assertFalse(Solution().sequenceReconstruction(intArrayOf(1, 2), arrayOf(intArrayOf(2, 1))))
    }
}
