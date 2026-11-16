package unitconversionii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class UnitConversionIiTest {
    private val conversions = arrayOf(intArrayOf(0, 1, 2), intArrayOf(1, 2, 3))

    @Test
    fun forwardRatioQueries() {
        val queries = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(0, 2))
        assertArrayEquals(intArrayOf(2, 3, 6), Solution().queryConversions(conversions, queries))
    }

    @Test
    fun inverseRatioQuery() {
        val queries = arrayOf(intArrayOf(1, 0))
        assertArrayEquals(intArrayOf(500000004), Solution().queryConversions(conversions, queries))
    }

    @Test
    fun identityQueries() {
        val queries = arrayOf(intArrayOf(0, 0), intArrayOf(2, 2))
        assertArrayEquals(intArrayOf(1, 1), Solution().queryConversions(conversions, queries))
    }
}
