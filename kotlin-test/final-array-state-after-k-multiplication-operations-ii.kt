package finalarraystateafterkmultiplicationoperationsii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FinalArrayStateAfterKMultiplicationOperationsIITest {
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
            intArrayOf(999999307, 999999993),
            Solution().getFinalState(intArrayOf(100000, 2000), 2, 1000000)
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
    fun largeKReducesModulo() {
        assertArrayEquals(
            intArrayOf(1, 1),
            Solution().getFinalState(intArrayOf(1, 1), 1000000000, 1)
        )
    }
}
