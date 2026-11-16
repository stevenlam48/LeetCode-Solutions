package minimumqueenmovestoreachtarget

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumQueenMovesToReachTargetTest {
    private val solution = Solution()

    @Test
    fun `same square requires no moves`() {
        assertEquals(0, solution.minQueenMoves(intArrayOf(3, 3), intArrayOf(3, 3)))
    }

    @Test
    fun `diagonal target requires one move`() {
        assertEquals(1, solution.minQueenMoves(intArrayOf(1, 1), intArrayOf(3, 3)))
    }

    @Test
    fun `target in same row requires one move`() {
        assertEquals(1, solution.minQueenMoves(intArrayOf(2, 4), intArrayOf(2, 7)))
    }

    @Test
    fun `unaligned target requires two moves`() {
        assertEquals(2, solution.minQueenMoves(intArrayOf(1, 2), intArrayOf(4, 6)))
    }

    @Test
    fun `target in same column requires one move`() {
        assertEquals(1, solution.minQueenMoves(intArrayOf(6, 2), intArrayOf(3, 2)))
    }
}
