package minimumbishopmovestoreachtarget

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumBishopMovesToReachTargetTest {
    @Test
    fun oneDiagonalMove() = assertEquals(1, Solution().minBishopMoves(intArrayOf(4, 4), intArrayOf(7, 7)))

    @Test
    fun twoDiagonalMoves() = assertEquals(2, Solution().minBishopMoves(intArrayOf(4, 4), intArrayOf(7, 5)))

    @Test
    fun differentColorSquares() = assertEquals(-1, Solution().minBishopMoves(intArrayOf(4, 4), intArrayOf(5, 6)))

    @Test
    fun sameSquareFollowsReference() = assertEquals(1, Solution().minBishopMoves(intArrayOf(4, 4), intArrayOf(4, 4)))
}
