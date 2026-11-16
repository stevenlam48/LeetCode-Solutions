package counttripletswithevenxorsetbitsi

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountTripletsWithEvenXorSetBitsITest {
    @Test
    fun exampleWithOneValidTriplet() {
        assertEquals(1, Solution().tripletCount(intArrayOf(1), intArrayOf(2), intArrayOf(3)))
    }

    @Test
    fun oddParityTripletIsExcluded() {
        assertEquals(0, Solution().tripletCount(intArrayOf(2), intArrayOf(2), intArrayOf(7)))
    }

    @Test
    fun countsParityCombinations() {
        assertEquals(
            2,
            Solution().tripletCount(intArrayOf(1, 2), intArrayOf(3, 4), intArrayOf(5))
        )
    }

    @Test
    fun emptyArrayProducesNoTriplets() {
        assertEquals(0, Solution().tripletCount(intArrayOf(), intArrayOf(1, 2), intArrayOf(3)))
    }

    @Test
    fun allEvenParityValuesProduceEveryTriplet() {
        assertEquals(6, Solution().tripletCount(intArrayOf(0, 0), intArrayOf(0, 0, 0), intArrayOf(0)))
    }
}
