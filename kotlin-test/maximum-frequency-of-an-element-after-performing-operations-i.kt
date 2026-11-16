package maximumfrequencyofanelementafterperformingoperationsi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumFrequencyOfAnElementAfterPerformingOperationsITest {
    @Test
    fun example1() {
        assertEquals(2, Solution().maxFrequency(intArrayOf(1, 4, 5), 1, 2))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().maxFrequency(intArrayOf(5, 11, 20, 20), 5, 1))
    }

    @Test
    fun noOperations() {
        assertEquals(1, Solution().maxFrequency(intArrayOf(1, 2, 3), 1, 0))
    }

    @Test
    fun allEqual() {
        assertEquals(3, Solution().maxFrequency(intArrayOf(1, 1, 1), 1, 0))
    }

    @Test
    fun mergeAll() {
        assertEquals(5, Solution().maxFrequency(intArrayOf(1, 2, 3, 4, 5), 2, 5))
    }
}
