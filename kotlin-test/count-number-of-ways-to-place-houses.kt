package countnumberofwaystoplacehouses

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountNumberOfWaysToPlaceHousesTest {
    private val solution = Solution()

    @Test
    fun onePlotPerSide() {
        assertEquals(4, solution.countHousePlacements(1))
    }

    @Test
    fun twoPlotsPerSide() {
        assertEquals(9, solution.countHousePlacements(2))
    }

    @Test
    fun threeAndFourPlotsPerSide() {
        assertEquals(25, solution.countHousePlacements(3))
        assertEquals(64, solution.countHousePlacements(4))
    }

    @Test
    fun tenPlotsPerSide() {
        assertEquals(20736, solution.countHousePlacements(10))
    }
}
