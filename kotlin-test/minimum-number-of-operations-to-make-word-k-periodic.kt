package minimumnumberofoperationstomakewordkperiodic

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfOperationsToMakeWordKPeriodicTest {
    private val solution = Solution()

    @Test
    fun twoRepeatedBlocks() {
        assertEquals(1, solution.minimumOperationsToMakeKPeriodic("leetcodeleet", 4))
    }

    @Test
    fun adjacentRepeatedBlocks() {
        assertEquals(1, solution.minimumOperationsToMakeKPeriodic("leetleatleet", 4))
    }

    @Test
    fun allBlocksDiffer() {
        assertEquals(1, solution.minimumOperationsToMakeKPeriodic("abcd", 2))
    }

    @Test
    fun singleBlock() {
        assertEquals(0, solution.minimumOperationsToMakeKPeriodic("jjjj", 4))
    }

    @Test
    fun allBlocksSame() {
        assertEquals(0, solution.minimumOperationsToMakeKPeriodic("abababab", 2))
    }
}
