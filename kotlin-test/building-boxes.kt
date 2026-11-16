package buildingboxes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BuildingBoxesTest {
    @Test
    fun threeBoxesNeedThreePositions() {
        assertEquals(3, Solution().minimumBoxes(3))
    }

    @Test
    fun fourthBoxSharesTheBase() {
        assertEquals(3, Solution().minimumBoxes(4))
    }

    @Test
    fun tenBoxes() {
        assertEquals(6, Solution().minimumBoxes(10))
    }

    @Test
    fun oneBox() {
        assertEquals(1, Solution().minimumBoxes(1))
    }
}
