package unitconversioni

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class UnitConversionITest {
    @Test
    fun conversionChain() {
        val conversions = arrayOf(intArrayOf(0, 1, 2), intArrayOf(1, 2, 3))
        assertArrayEquals(intArrayOf(1, 2, 6), Solution().baseUnitConversions(conversions))
    }

    @Test
    fun branchingConversions() {
        val conversions = arrayOf(
            intArrayOf(0, 1, 2),
            intArrayOf(1, 2, 3),
            intArrayOf(0, 3, 4)
        )
        assertArrayEquals(intArrayOf(1, 2, 6, 4), Solution().baseUnitConversions(conversions))
    }

    @Test
    fun noConversions() {
        assertArrayEquals(intArrayOf(1), Solution().baseUnitConversions(emptyArray()))
    }
}
