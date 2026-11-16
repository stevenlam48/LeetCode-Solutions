package containsduplicateii

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ContainsDuplicateIiTest {
    @Test
    fun duplicateAtDistanceThree() {
        assertTrue(Solution().containsNearbyDuplicate(intArrayOf(1, 2, 3, 1), 3))
    }

    @Test
    fun adjacentDuplicateWithDistanceLimitOne() {
        assertTrue(Solution().containsNearbyDuplicate(intArrayOf(1, 0, 1, 1), 1))
    }

    @Test
    fun allDuplicatesAreTooFarApart() {
        assertFalse(Solution().containsNearbyDuplicate(intArrayOf(1, 2, 3, 1, 2, 3), 2))
    }

    @Test
    fun zeroDistanceCannotMatchDifferentIndices() {
        assertFalse(Solution().containsNearbyDuplicate(intArrayOf(1, 1), 0))
    }
}
