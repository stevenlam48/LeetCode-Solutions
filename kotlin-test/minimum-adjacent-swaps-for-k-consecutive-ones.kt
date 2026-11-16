package minimumadjacentswapsforkconsecutiveones

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumAdjacentSwapsForKConsecutiveOnesTest {
    @Test
    fun example1() {
        assertEquals(1, Solution().minMoves(intArrayOf(1, 0, 0, 1, 0, 1), 2))
    }

    @Test
    fun example2() {
        assertEquals(5, Solution().minMoves(intArrayOf(1, 0, 0, 0, 0, 0, 1, 1), 3))
    }

    @Test
    fun example3() {
        assertEquals(0, Solution().minMoves(intArrayOf(1, 1, 0, 0, 1), 2))
    }

    @Test
    fun singleOne() {
        assertEquals(0, Solution().minMoves(intArrayOf(1, 0, 1), 1))
    }

    @Test
    fun allOnes() {
        assertEquals(0, Solution().minMoves(intArrayOf(1, 1, 1), 3))
    }
}
