package minimumoperationstomakearrayparityalternating

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeArrayParityAlternatingTest {
    @Test
    fun testSingleElement() {
        assertArrayEquals(intArrayOf(0, 0), Solution().makeParityAlternating(intArrayOf(8)))
    }

    @Test
    fun testAlreadyAlternating() {
        assertArrayEquals(intArrayOf(0, 1), Solution().makeParityAlternating(intArrayOf(1, 2)))
    }

    @Test
    fun testTwoMismatchesUnderFirstTarget() {
        assertArrayEquals(intArrayOf(1, 1), Solution().makeParityAlternating(intArrayOf(2, 4)))
    }

    @Test
    fun testAllEqualValues() {
        assertArrayEquals(
            intArrayOf(1, 1),
            Solution().makeParityAlternating(intArrayOf(5, 5, 5))
        )
    }

    @Test
    fun testNegativeValuesContributeToRange() {
        assertArrayEquals(intArrayOf(0, 3), Solution().makeParityAlternating(intArrayOf(-2, 1)))
    }
}
