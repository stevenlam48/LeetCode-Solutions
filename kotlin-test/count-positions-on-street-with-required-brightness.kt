package countpositionsonstreetwithrequiredbrightness

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountPositionsOnStreetWithRequiredBrightnessTest {
    private val solution = Solution()

    @Test
    fun example() {
        assertEquals(
            4,
            solution.meetRequirement(
                5,
                arrayOf(intArrayOf(0, 1), intArrayOf(2, 1), intArrayOf(3, 2)),
                intArrayOf(0, 2, 1, 4, 1)
            )
        )
    }

    @Test
    fun overlappingLights() {
        assertEquals(
            2,
            solution.meetRequirement(
                3,
                arrayOf(intArrayOf(0, 1), intArrayOf(2, 2)),
                intArrayOf(1, 1, 2)
            )
        )
    }

    @Test
    fun noLights() {
        assertEquals(1, solution.meetRequirement(3, emptyArray(), intArrayOf(1, 0, 1)))
        assertEquals(3, solution.meetRequirement(3, emptyArray(), intArrayOf(0, 0, 0)))
    }

    @Test
    fun singlePosition() {
        assertEquals(
            1,
            solution.meetRequirement(1, arrayOf(intArrayOf(0, 0)), intArrayOf(1))
        )
    }
}
