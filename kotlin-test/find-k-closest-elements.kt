package findkclosestelements

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindKClosestElementsTest {
    @Test
    fun findsClosestWindowAroundExistingValue() {
        assertArrayEquals(
            intArrayOf(1, 2, 3, 4),
            Solution().findClosestElements(intArrayOf(1, 2, 3, 4, 5), 4, 3)
        )
    }

    @Test
    fun prefersLeftValueOnEqualDistance() {
        assertArrayEquals(
            intArrayOf(1, 2, 3, 4),
            Solution().findClosestElements(intArrayOf(1, 2, 3, 4, 5), 4, -1)
        )
    }

    @Test
    fun selectsRightmostWindowWhenTargetIsLarge() {
        assertArrayEquals(
            intArrayOf(3, 4, 5),
            Solution().findClosestElements(intArrayOf(1, 2, 3, 4, 5), 3, 10)
        )
    }

    @Test
    fun handlesDuplicatesAndSingleElementResult() {
        assertArrayEquals(
            intArrayOf(2, 2),
            Solution().findClosestElements(intArrayOf(1, 2, 2, 3), 2, 2)
        )
        assertArrayEquals(
            intArrayOf(1),
            Solution().findClosestElements(intArrayOf(1), 1, 1)
        )
    }
}
