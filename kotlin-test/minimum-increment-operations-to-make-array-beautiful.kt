package minimumincrementoperationstomakearraybeautiful
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumIncrementOperationsToMakeArrayBeautifulTest {
    @Test
    fun firstExample() {
        assertEquals(3L, Solution().minIncrementOperations(intArrayOf(2, 3, 0, 0, 2), 4))
    }

    @Test
    fun oneElementCanCoverBothWindows() {
        assertEquals(2L, Solution().minIncrementOperations(intArrayOf(0, 1, 3, 3), 5))
    }

    @Test
    fun sharedWindowIncrement() {
        assertEquals(1L, Solution().minIncrementOperations(intArrayOf(1, 1, 2, 1), 3))
    }

    @Test
    fun alreadyBeautiful() {
        assertEquals(0L, Solution().minIncrementOperations(intArrayOf(3, 0, 3, 0, 3), 3))
    }

    @Test
    fun resultExceedsIntRange() {
        assertEquals(3_000_000_000L, Solution().minIncrementOperations(IntArray(9), 1_000_000_000))
    }
}
