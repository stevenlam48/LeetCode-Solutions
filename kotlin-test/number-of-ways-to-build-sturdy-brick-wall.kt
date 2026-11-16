package numberofwaystobuildsturdybrickwall

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToBuildSturdyBrickWallTest {
    @Test
    fun example1() {
        assertEquals(2, Solution().buildWall(2, 3, intArrayOf(1, 2)))
    }

    @Test
    fun impossible() {
        assertEquals(0, Solution().buildWall(1, 1, intArrayOf(5)))
    }

    @Test
    fun singleBrick() {
        assertEquals(1, Solution().buildWall(1, 1, intArrayOf(1)))
    }

    @Test
    fun threeBrickSizes() {
        assertEquals(9, Solution().buildWall(2, 3, intArrayOf(1, 2, 3)))
    }

    @Test
    fun threeRows() {
        assertEquals(5, Solution().buildWall(3, 2, intArrayOf(1, 2)))
    }
}
