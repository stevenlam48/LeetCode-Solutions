package minimumnumberofkconsecutivebitflips

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfKConsecutiveBitFlipsTest {
    private val solution = Solution()

    @Test
    fun flipsWithKOne() {
        assertEquals(2, solution.minKBitFlips(intArrayOf(0, 1, 0), 1))
    }

    @Test
    fun impossibleCase() {
        assertEquals(-1, solution.minKBitFlips(intArrayOf(1, 1, 0), 2))
    }

    @Test
    fun longerArray() {
        assertEquals(3, solution.minKBitFlips(intArrayOf(0, 0, 0, 1, 0, 1, 1, 0), 3))
    }

    @Test
    fun singleWindow() {
        assertEquals(1, solution.minKBitFlips(intArrayOf(0, 0, 0), 3))
    }

    @Test
    fun alreadyAllOnes() {
        assertEquals(0, solution.minKBitFlips(intArrayOf(1, 1, 1), 2))
    }
}
