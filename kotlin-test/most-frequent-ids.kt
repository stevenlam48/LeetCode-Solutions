package mostfrequentids

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MostFrequentIdsTest {
    private val solution = Solution()

    @Test
    fun tracksMaximumAfterEachFrequencyChange() {
        assertArrayEquals(
            longArrayOf(3, 3, 2, 2),
            solution.mostFrequentIDs(intArrayOf(2, 3, 2, 1), intArrayOf(3, 2, -3, 1))
        )
    }

    @Test
    fun removesStaleHeapEntries() {
        assertArrayEquals(
            longArrayOf(1, 0, 1),
            solution.mostFrequentIDs(intArrayOf(2, 2, 2), intArrayOf(1, -1, 1))
        )
    }

    @Test
    fun handlesSeveralIdentifiers() {
        assertArrayEquals(
            longArrayOf(2, 5, 5, 7),
            solution.mostFrequentIDs(intArrayOf(1, 2, 1, 2), intArrayOf(2, 5, 1, 2))
        )
    }
}
