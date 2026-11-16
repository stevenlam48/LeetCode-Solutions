package concatenatearraywithreverse

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ConcatenateArrayWithReverseTest {
    @Test
    fun appendsReverseCopy() {
        assertArrayEquals(intArrayOf(1, 2, 3, 3, 2, 1), Solution().concatWithReverse(intArrayOf(1, 2, 3)))
    }

    @Test
    fun preservesDuplicatesAndNegativeValues() {
        assertArrayEquals(intArrayOf(-1, 0, -1, -1, 0, -1), Solution().concatWithReverse(intArrayOf(-1, 0, -1)))
    }

    @Test
    fun handlesEmptyAndSingleElementInputs() {
        assertArrayEquals(intArrayOf(), Solution().concatWithReverse(intArrayOf()))
        assertArrayEquals(intArrayOf(7, 7), Solution().concatWithReverse(intArrayOf(7)))
    }
}
