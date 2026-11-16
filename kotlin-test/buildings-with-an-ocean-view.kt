package buildingswithanoceanview

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class BuildingsWithAnOceanViewTest {
    @Test
    fun leetCodeExample() {
        assertArrayEquals(intArrayOf(0, 2, 3), Solution().findBuildings(intArrayOf(4, 2, 3, 1)))
    }

    @Test
    fun equalHeightsKeepOnlyTheRightmost() {
        assertArrayEquals(intArrayOf(3), Solution().findBuildings(intArrayOf(2, 2, 2, 2)))
    }

    @Test
    fun shorterBuildingsAfterAViewDoNotHideIt() {
        assertArrayEquals(intArrayOf(1, 3, 4), Solution().findBuildings(intArrayOf(2, 4, 2, 3, 2)))
    }

    @Test
    fun emptyAndSingleBuilding() {
        assertArrayEquals(intArrayOf(), Solution().findBuildings(intArrayOf()))
        assertArrayEquals(intArrayOf(0), Solution().findBuildings(intArrayOf(7)))
    }
}
