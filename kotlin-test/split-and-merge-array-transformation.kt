package splitandmergearraytransformation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SplitAndMergeArrayTransformationTest {
    @Test
    fun alreadyEqual() {
        assertEquals(0, Solution().minSplitMerge(intArrayOf(1, 2, 3), intArrayOf(1, 2, 3)))
    }

    @Test
    fun oneOperationSwap() {
        assertEquals(1, Solution().minSplitMerge(intArrayOf(1, 2), intArrayOf(2, 1)))
    }

    @Test
    fun oneOperationRotation() {
        assertEquals(1, Solution().minSplitMerge(intArrayOf(1, 2, 3), intArrayOf(3, 1, 2)))
    }

    @Test
    fun twoOperations() {
        assertEquals(2, Solution().minSplitMerge(intArrayOf(1, 2, 3, 4), intArrayOf(1, 4, 3, 2)))
    }

    @Test
    fun singleElement() {
        assertEquals(0, Solution().minSplitMerge(intArrayOf(5), intArrayOf(5)))
    }
}
