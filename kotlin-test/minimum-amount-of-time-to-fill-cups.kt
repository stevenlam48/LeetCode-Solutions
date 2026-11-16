package minimumamountoftimetofillcups

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumAmountOfTimeToFillCupsTest {
    @Test
    fun standardExample() = assertEquals(4, Solution().fillCups(intArrayOf(1, 4, 2)))

    @Test
    fun balancedCups() = assertEquals(7, Solution().fillCups(intArrayOf(5, 4, 4)))

    @Test
    fun oneNonemptyCup() = assertEquals(5, Solution().fillCups(intArrayOf(5, 0, 0)))

    @Test
    fun allEmpty() = assertEquals(0, Solution().fillCups(intArrayOf(0, 0, 0)))
}
