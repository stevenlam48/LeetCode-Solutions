package findmissingobservations

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindMissingObservationsTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertArrayEquals(intArrayOf(6, 6), solution.missingRolls(intArrayOf(3, 2, 4, 3), 4, 2))
    }

    @Test
    fun exampleTwo() {
        assertArrayEquals(intArrayOf(3, 2, 2, 2), solution.missingRolls(intArrayOf(1, 5, 6), 3, 4))
    }

    @Test
    fun exampleImpossible() {
        assertArrayEquals(intArrayOf(), solution.missingRolls(intArrayOf(1, 2, 3, 4), 6, 4))
    }

    @Test
    fun allMinimumRolls() {
        assertArrayEquals(intArrayOf(1, 1, 1), solution.missingRolls(intArrayOf(6, 1), 2, 3))
    }
}
