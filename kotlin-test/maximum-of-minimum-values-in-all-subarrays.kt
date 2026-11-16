package maximumofminimumvaluesinallsubarrays

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MaximumOfMinimumValuesInAllSubarraysTest {
    @Test
    fun mixedValues() {
        assertArrayEquals(intArrayOf(11, 3, 2, 2, 1, 1, 0), Solution().findMaximums(intArrayOf(0, 11, 3, 2, 9, 1, 8)))
    }

    @Test
    fun singleElement() {
        assertArrayEquals(intArrayOf(5), Solution().findMaximums(intArrayOf(5)))
    }

    @Test
    fun ascendingValues() {
        assertArrayEquals(intArrayOf(3, 2, 1), Solution().findMaximums(intArrayOf(1, 2, 3)))
    }

    @Test
    fun duplicates() {
        assertArrayEquals(intArrayOf(2, 2, 2), Solution().findMaximums(intArrayOf(2, 2, 2)))
    }
}
