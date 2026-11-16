package minimumoperationstomakethearraykincreasing

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeTheArrayKIncreasingTest {
    @Test
    fun strictlyDecreasingWithKOne() {
        assertEquals(4, Solution().kIncreasing(intArrayOf(5, 4, 3, 2, 1), 1))
    }

    @Test
    fun alreadyNonDecreasingPerResidue() {
        assertEquals(0, Solution().kIncreasing(intArrayOf(4, 1, 5, 2, 6, 2), 2))
    }

    @Test
    fun needsTwoChanges() {
        assertEquals(2, Solution().kIncreasing(intArrayOf(4, 1, 5, 2, 6, 2), 3))
    }

    @Test
    fun increasingArrayKOne() {
        assertEquals(0, Solution().kIncreasing(intArrayOf(1, 2, 3), 1))
    }
}
