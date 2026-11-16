package containsduplicateiii

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ContainsDuplicateIiiTest {
    @Test
    fun equalValuesWithinIndexDistance() {
        assertTrue(Solution().containsNearbyAlmostDuplicate(intArrayOf(1, 2, 3, 1), 3, 0))
    }

    @Test
    fun closeValuesWithinIndexDistance() {
        assertTrue(Solution().containsNearbyAlmostDuplicate(intArrayOf(1, 0, 1, 1), 1, 2))
    }

    @Test
    fun noNearbyAlmostDuplicate() {
        assertFalse(Solution().containsNearbyAlmostDuplicate(intArrayOf(1, 5, 9, 1, 5, 9), 2, 3))
    }

    @Test
    fun integerExtremesDoNotOverflowDifferenceCalculation() {
        assertFalse(
            Solution().containsNearbyAlmostDuplicate(intArrayOf(Int.MIN_VALUE, Int.MAX_VALUE), 1, 1)
        )
    }
}
