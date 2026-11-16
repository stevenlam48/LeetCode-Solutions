package minimumarraychangestomakedifferencesequal

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumArrayChangesToMakeDifferencesEqualTest {
    @Test
    fun standardExample() = assertEquals(2, Solution().minChanges(intArrayOf(1, 0, 1, 2, 4, 3), 4))

    @Test
    fun zeroDifferenceAlready() = assertEquals(0, Solution().minChanges(intArrayOf(0, 1, 1, 0), 1))

    @Test
    fun binaryChoices() = assertEquals(1, Solution().minChanges(intArrayOf(0, 1, 0, 0), 1))

    @Test
    fun singleMatchingPair() = assertEquals(0, Solution().minChanges(intArrayOf(3, 3), 5))
}
