package magneticforcebetweentwoballs

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MagneticForceBetweenTwoBallsTest {
    private val solution = Solution()

    @Test
    fun maximizesMinimumForceInThreeBallExample() {
        assertEquals(3, solution.maxDistance(intArrayOf(1, 2, 3, 4, 7), 3))
    }

    @Test
    fun sortsPositionsAndUsesDistantBasket() {
        assertEquals(
            999999999,
            solution.maxDistance(intArrayOf(5, 4, 3, 2, 1, 1000000000), 2)
        )
    }

    @Test
    fun allowsZeroDistanceForDuplicatePositions() {
        assertEquals(0, solution.maxDistance(intArrayOf(1, 1, 1, 1), 2))
    }

    @Test
    fun findsMaximumAcrossUnevenGaps() {
        assertEquals(3, solution.maxDistance(intArrayOf(9, 1, 8, 2, 4), 3))
    }
}
