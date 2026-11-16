package reorderedpowerof2

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ReorderedPowerOf2Test {
    private val solution = Solution()

    @Test
    fun oneIsPowerOfTwo() {
        assertTrue(solution.reorderedPowerOf2(1))
    }

    @Test
    fun tenCannotBeReordered() {
        assertFalse(solution.reorderedPowerOf2(10))
    }

    @Test
    fun digitsCanBeReorderedToSixtyFour() {
        assertTrue(solution.reorderedPowerOf2(46))
    }

    @Test
    fun existingPowerOfTwoIsAccepted() {
        assertTrue(solution.reorderedPowerOf2(128))
    }

    @Test
    fun zeroIsNotPowerOfTwo() {
        assertFalse(solution.reorderedPowerOf2(0))
    }
}
