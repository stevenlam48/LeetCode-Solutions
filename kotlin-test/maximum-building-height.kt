package maximumbuildingheight

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumBuildingHeightTest {
    @Test
    fun example() {
        assertEquals(2, Solution().maxBuilding(5, arrayOf(intArrayOf(2, 1), intArrayOf(4, 1))))
    }

    @Test
    fun anotherExample() {
        assertEquals(2, Solution().maxBuilding(6, arrayOf(intArrayOf(2, 1), intArrayOf(5, 0))))
    }

    @Test
    fun threeRestrictions() {
        assertEquals(
            7,
            Solution().maxBuilding(
                10,
                arrayOf(intArrayOf(5, 3), intArrayOf(2, 5), intArrayOf(7, 4))
            )
        )
    }

    @Test
    fun singleBuilding() {
        assertEquals(0, Solution().maxBuilding(1, arrayOf()))
    }
}
