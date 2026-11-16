package furthestpointfromorigin

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FurthestPointFromOriginTest {
    @Test
    fun example1() {
        assertEquals(3, Solution().furthestDistanceFromOrigin("L_RL__R"))
    }

    @Test
    fun example2() {
        assertEquals(5, Solution().furthestDistanceFromOrigin("_R__LL_"))
    }

    @Test
    fun example3() {
        assertEquals(7, Solution().furthestDistanceFromOrigin("_______"))
    }

    @Test
    fun singleLeft() {
        assertEquals(1, Solution().furthestDistanceFromOrigin("L"))
    }

    @Test
    fun noUnderscores() {
        assertEquals(4, Solution().furthestDistanceFromOrigin("RRRR"))
    }

    @Test
    fun balancedWithOneWildcard() {
        assertEquals(1, Solution().furthestDistanceFromOrigin("LR_"))
    }
}
