package findthearrayconcatenationvalue

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class FindTheArrayConcatenationValueTest {
    @Test
    fun matchesReferenceForEvenLengthArray() {
        assertEquals(596L, Solution().findTheArrayConcVal(intArrayOf(7, 52, 2, 4)))
    }

    @Test
    fun matchesReferenceForOddLengthArray() {
        assertEquals(673L, Solution().findTheArrayConcVal(intArrayOf(5, 14, 13, 8, 12)))
    }

    @Test
    fun returnsSingleElement() {
        assertEquals(42L, Solution().findTheArrayConcVal(intArrayOf(42)))
    }

    @Test
    fun returnsZeroForEmptyArray() {
        assertEquals(0L, Solution().findTheArrayConcVal(intArrayOf()))
    }
}
