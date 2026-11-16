package aliceandbobplayingflowergame

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AliceAndBobPlayingFlowerGameTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        assertEquals(3L, solution.flowerGame(3, 2))
    }

    @Test
    fun secondExample() {
        assertEquals(0L, solution.flowerGame(1, 1))
    }

    @Test
    fun equalDimensions() {
        assertEquals(8L, solution.flowerGame(4, 4))
    }

    @Test
    fun productExceedsIntRange() {
        assertEquals(5_000_000_000L, solution.flowerGame(100000, 100000))
    }
}
