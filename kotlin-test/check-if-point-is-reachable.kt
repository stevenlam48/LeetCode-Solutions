package checkifpointisreachable

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckIfPointIsReachableTest {
    private val solution = Solution()

    @Test
    fun gcdHasOddFactor() {
        assertFalse(solution.isReachable(6, 9))
    }

    @Test
    fun coprimeCoordinates() {
        assertTrue(solution.isReachable(4, 7))
    }

    @Test
    fun gcdIsPowerOfTwo() {
        assertTrue(solution.isReachable(2, 4))
    }

    @Test
    fun largerGcdIsNotPowerOfTwo() {
        assertFalse(solution.isReachable(6, 12))
    }

    @Test
    fun unitPoint() {
        assertTrue(solution.isReachable(1, 1))
    }
}
