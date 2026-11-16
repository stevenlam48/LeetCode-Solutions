package minimumoperationstomakethearraybeautiful

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeTheArrayBeautifulTest {
    @Test
    fun example() {
        assertEquals(1, Solution().minOperations(intArrayOf(1, 2, 3)))
    }

    @Test
    fun allOnes() {
        assertEquals(0, Solution().minOperations(intArrayOf(1, 1, 1)))
    }

    @Test
    fun equalPair() {
        assertEquals(0, Solution().minOperations(intArrayOf(2, 2)))
    }

    @Test
    fun needsOneChange() {
        assertEquals(1, Solution().minOperations(intArrayOf(2, 3)))
    }
}
