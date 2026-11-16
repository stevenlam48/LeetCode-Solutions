package findallpossiblestablebinaryarraysi

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindAllPossibleStableBinaryArraysITest {
    @Test
    fun oneOfEachWithLongRunsAllowed() {
        assertEquals(2, Solution().numberOfStableArrays(1, 1, 2))
    }

    @Test
    fun alternatingArrayOnly() {
        assertEquals(1, Solution().numberOfStableArrays(1, 2, 1))
    }

    @Test
    fun balancedArraysWithLimitedRuns() {
        assertEquals(14, Solution().numberOfStableArrays(3, 3, 2))
    }

    @Test
    fun singleKindOfBit() {
        assertEquals(1, Solution().numberOfStableArrays(3, 0, 3))
        assertEquals(0, Solution().numberOfStableArrays(4, 0, 3))
    }
}
