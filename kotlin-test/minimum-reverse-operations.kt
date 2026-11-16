package minimumreverseoperations

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MinimumReverseOperationsTest {
    @Test
    fun example1() {
        assertArrayEquals(
            intArrayOf(0, -1, -1, 1),
            Solution().minReverseOperations(4, 0, intArrayOf(1, 2), 4)
        )
    }

    @Test
    fun bannedTarget() {
        assertArrayEquals(
            intArrayOf(0, -1, -1, 1, -1),
            Solution().minReverseOperations(5, 0, intArrayOf(2), 4)
        )
    }

    @Test
    fun kEqualsOne() {
        assertArrayEquals(
            intArrayOf(-1, 0, -1),
            Solution().minReverseOperations(3, 1, intArrayOf(), 1)
        )
    }

    @Test
    fun parityRestriction() {
        assertArrayEquals(
            intArrayOf(1, -1, 0, -1),
            Solution().minReverseOperations(4, 2, intArrayOf(), 3)
        )
    }

    @Test
    fun wholeArrayReverse() {
        assertArrayEquals(
            intArrayOf(0, 1),
            Solution().minReverseOperations(2, 0, intArrayOf(), 2)
        )
    }
}
