package minimumincompatibility
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumIncompatibilityTest {
    @Test
    fun firstExample() {
        assertEquals(4, Solution().minimumIncompatibility(intArrayOf(1, 2, 1, 4), 2))
    }

    @Test
    fun repeatedValuesAcrossGroups() {
        assertEquals(3, Solution().minimumIncompatibility(intArrayOf(2, 1, 2, 1, 2, 1), 3))
    }

    @Test
    fun thirdExample() {
        assertEquals(6, Solution().minimumIncompatibility(intArrayOf(6, 3, 8, 1, 3, 1, 2, 2), 4))
    }

    @Test
    fun impossibleBecauseOfDuplicates() {
        assertEquals(-1, Solution().minimumIncompatibility(intArrayOf(1, 1, 1, 1), 2))
    }

    @Test
    fun rejectsGreedyPartition() {
        val nums = intArrayOf(15, 9, 7, 10, 15, 14, 12, 2, 10, 8, 10, 13, 4, 11, 2)
        assertEquals(22, Solution().minimumIncompatibility(nums, 5))
    }
}
