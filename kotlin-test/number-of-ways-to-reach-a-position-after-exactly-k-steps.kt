package numberofwaystoreachapositionafterexactlyksteps

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfWaysToReachAPositionAfterExactlyKStepsTest {
    @Test
    fun firstExample() {
        assertEquals(3, Solution().numberOfWays(1, 2, 3))
    }

    @Test
    fun secondExample() {
        assertEquals(0, Solution().numberOfWays(2, 5, 10))
    }

    @Test
    fun returnsToStart() {
        assertEquals(6, Solution().numberOfWays(0, 0, 4))
    }

    @Test
    fun repeatedQueriesShareFactorials() {
        val solution = Solution()
        assertEquals(3, solution.numberOfWays(1, 2, 3))
        assertEquals(20, solution.numberOfWays(0, 0, 6))
    }
}
