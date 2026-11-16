package waterandjugproblem

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class WaterAndJugProblemTest {
    private val solution = Solution()

    @Test
    fun example1() {
        assertTrue(solution.canMeasureWater(3, 5, 4))
    }

    @Test
    fun example2() {
        assertFalse(solution.canMeasureWater(2, 6, 5))
    }

    @Test
    fun example3() {
        assertTrue(solution.canMeasureWater(1, 2, 3))
    }

    @Test
    fun zeroTarget() {
        assertTrue(solution.canMeasureWater(0, 0, 0))
    }

    @Test
    fun targetExceedsTotalCapacity() {
        assertFalse(solution.canMeasureWater(0, 0, 1))
        assertFalse(solution.canMeasureWater(1, 1, 3))
    }

    @Test
    fun targetNotMultipleOfGcd() {
        assertFalse(solution.canMeasureWater(2, 4, 3))
        assertTrue(solution.canMeasureWater(2, 4, 2))
    }
}
