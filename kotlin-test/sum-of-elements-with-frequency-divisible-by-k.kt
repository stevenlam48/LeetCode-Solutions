package sumofelementswithfrequencydivisiblebyk

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SumOfElementsWithFrequencyDivisibleByKTest {
    @Test
    fun evenFrequencies() {
        assertEquals(16, Solution().sumDivisibleByK(intArrayOf(1, 2, 2, 3, 3, 3, 3), 2))
    }

    @Test
    fun kEqualsOne() {
        assertEquals(17, Solution().sumDivisibleByK(intArrayOf(1, 2, 2, 3, 3, 3, 3), 1))
    }

    @Test
    fun noFrequencyDivisible() {
        assertEquals(0, Solution().sumDivisibleByK(intArrayOf(1, 2, 2, 3, 3, 3, 3), 3))
    }

    @Test
    fun allEqual() {
        assertEquals(15, Solution().sumDivisibleByK(intArrayOf(5, 5, 5), 3))
    }
}
