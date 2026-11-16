package minimizingarrayafterreplacingpairswiththeirproduct

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimizingArrayAfterReplacingPairsWithTheirProductTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().minArrayLength(intArrayOf(2, 3, 3, 2, 3, 3), 10))
    }

    @Test
    fun example2() {
        assertEquals(2, Solution().minArrayLength(intArrayOf(1, 2, 3), 5))
    }

    @Test
    fun allOnes() {
        assertEquals(1, Solution().minArrayLength(intArrayOf(1, 1, 1), 1))
    }

    @Test
    fun containsZero() {
        assertEquals(1, Solution().minArrayLength(intArrayOf(0, 5), 10))
    }

    @Test
    fun singleElement() {
        assertEquals(1, Solution().minArrayLength(intArrayOf(5), 10))
    }

    @Test
    fun pairs() {
        assertEquals(2, Solution().minArrayLength(intArrayOf(2, 2, 2), 4))
    }
}
