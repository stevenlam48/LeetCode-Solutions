package maximumpopulationyear

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class MaximumPopulationYearTest {
    @Test
    fun firstExample() {
        val logs = arrayOf(intArrayOf(1993, 1999), intArrayOf(2000, 2010))
        assertEquals(1993, Solution().maximumPopulation(logs))
    }

    @Test
    fun secondExampleUsesEarliestYearOnTie() {
        val logs = arrayOf(intArrayOf(1950, 1961), intArrayOf(1960, 1971), intArrayOf(1970, 1981))
        assertEquals(1960, Solution().maximumPopulation(logs))
    }

    @Test
    fun deathYearIsExclusive() {
        val logs = arrayOf(intArrayOf(1950, 1951), intArrayOf(1951, 1952))
        assertEquals(1950, Solution().maximumPopulation(logs))
    }

    @Test
    fun emptyLogs() {
        assertEquals(1950, Solution().maximumPopulation(emptyArray()))
    }
}
