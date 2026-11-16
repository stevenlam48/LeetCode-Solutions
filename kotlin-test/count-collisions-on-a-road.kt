package countcollisionsonaroad

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountCollisionsOnARoadTest {
    @Test
    fun example() {
        assertEquals(5, Solution().countCollisions("RLRSLL"))
    }

    @Test
    fun movingAway() {
        assertEquals(0, Solution().countCollisions("LLRR"))
        assertEquals(0, Solution().countCollisions(""))
    }

    @Test
    fun simpleCollisions() {
        assertEquals(1, Solution().countCollisions("RS"))
        assertEquals(2, Solution().countCollisions("RL"))
    }

    @Test
    fun stoppedAndMovingCars() {
        assertEquals(4, Solution().countCollisions("SSRSSRLL"))
    }
}
