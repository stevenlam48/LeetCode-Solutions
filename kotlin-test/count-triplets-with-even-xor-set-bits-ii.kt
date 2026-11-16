package counttripletswithevenxorsetbitsii

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountTripletsWithEvenXorSetBitsIITest {
    @Test
    fun exampleWithOneValidTriplet() {
        assertEquals(1L, Solution().tripletCount(intArrayOf(1), intArrayOf(2), intArrayOf(3)))
    }

    @Test
    fun oddParityTripletIsExcluded() {
        assertEquals(0L, Solution().tripletCount(intArrayOf(2), intArrayOf(2), intArrayOf(7)))
    }

    @Test
    fun countsParityCombinations() {
        assertEquals(
            2L,
            Solution().tripletCount(intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(5))
        )
    }

    @Test
    fun emptyArrayProducesNoTriplets() {
        assertEquals(0L, Solution().tripletCount(intArrayOf(), intArrayOf(1, 2), intArrayOf(3)))
    }

    @Test
    fun resultUsesLongArithmetic() {
        val values = IntArray(2_000)
        assertEquals(
            8_000_000_000L,
            Solution().tripletCount(values, values, values)
        )
    }
}
