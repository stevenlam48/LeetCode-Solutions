package furthestbuildingyoucanreach

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FurthestBuildingYouCanReachTest {
    @Test
    fun example1() {
        assertEquals(
            4,
            Solution().furthestBuilding(intArrayOf(4, 2, 7, 6, 9, 14, 12), 5, 1)
        )
    }

    @Test
    fun example2() {
        assertEquals(
            7,
            Solution().furthestBuilding(
                intArrayOf(4, 12, 2, 7, 3, 18, 20, 3, 19), 10, 2
            )
        )
    }

    @Test
    fun example3() {
        assertEquals(
            3,
            Solution().furthestBuilding(intArrayOf(14, 3, 19, 3), 5, 1)
        )
    }

    @Test
    fun cannotClimbFirstStep() {
        assertEquals(0, Solution().furthestBuilding(intArrayOf(1, 2), 0, 0))
    }

    @Test
    fun singleBuilding() {
        assertEquals(0, Solution().furthestBuilding(intArrayOf(7), 0, 0))
    }

    @Test
    fun laddersCoverEverything() {
        assertEquals(
            4,
            Solution().furthestBuilding(intArrayOf(1, 5, 1, 2, 3), 0, 10)
        )
    }
}
