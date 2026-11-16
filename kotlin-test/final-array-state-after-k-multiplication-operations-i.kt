package finalarraystateafterkmultiplicationoperationsi

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FinalArrayStateAfterKMultiplicationOperationsITest {
    @Test
    fun example1() {
        assertArrayEquals(
            intArrayOf(8, 4, 6, 5, 6),
            Solution().getFinalState(intArrayOf(2, 1, 3, 5, 6), 5, 2)
        )
    }

    @Test
    fun example2() {
        assertArrayEquals(
            intArrayOf(16, 8),
            Solution().getFinalState(intArrayOf(1, 2), 3, 4)
        )
    }

    @Test
    fun multiplierOneLeavesArrayUnchanged() {
        assertArrayEquals(
            intArrayOf(3, 1, 2),
            Solution().getFinalState(intArrayOf(3, 1, 2), 7, 1)
        )
    }

    @Test
    fun zeroOperations() {
        assertArrayEquals(
            intArrayOf(4, 2),
            Solution().getFinalState(intArrayOf(4, 2), 0, 3)
        )
    }

    @Test
    fun singleElement() {
        assertArrayEquals(
            intArrayOf(40),
            Solution().getFinalState(intArrayOf(5), 3, 2)
        )
    }

    @Test
    fun manyOperationsOnSmallArray() {
        assertArrayEquals(
            intArrayOf(32, 16),
            Solution().getFinalState(intArrayOf(1, 1), 9, 2)
        )
    }
}
