package appendkintegerswithminimalsum

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class AppendKIntegersWithMinimalSumTest {
    private val solution = Solution()

    @Test
    fun skipsExistingValuesAndDuplicates() {
        assertEquals(5L, solution.minimalKSum(intArrayOf(1, 4, 25, 10, 25), 2))
    }

    @Test
    fun appendsSixValues() {
        assertEquals(25L, solution.minimalKSum(intArrayOf(5, 6), 6))
    }

    @Test
    fun noExistingSmallValues() {
        assertEquals(15L, solution.minimalKSum(intArrayOf(100, 200), 5))
    }

    @Test
    fun oneValueAlreadyPresent() {
        assertEquals(7L, solution.minimalKSum(intArrayOf(1, 2, 2), 2))
    }
}
