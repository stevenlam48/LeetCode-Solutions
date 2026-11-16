package findthemaximumnumberofelementsinsubset

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheMaximumNumberOfElementsInSubsetTest {
    @Test
    fun mixedPowersAndOnes() {
        assertEquals(3, Solution().maximumLength(intArrayOf(5, 4, 1, 2, 2)))
    }

    @Test
    fun evenNumberOfOnes() {
        assertEquals(1, Solution().maximumLength(intArrayOf(1, 3, 1)))
    }

    @Test
    fun oddNumberOfOnes() {
        assertEquals(3, Solution().maximumLength(intArrayOf(1, 1, 1)))
    }

    @Test
    fun oneCompletePowerChain() {
        assertEquals(5, Solution().maximumLength(intArrayOf(2, 2, 4, 4, 16)))
    }

    @Test
    fun longerPowerChain() {
        assertEquals(7, Solution().maximumLength(intArrayOf(2, 2, 4, 4, 16, 16, 256)))
    }
}
