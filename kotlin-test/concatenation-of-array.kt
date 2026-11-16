package concatenationofarray

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ConcatenationOfArrayTest {
    @Test
    fun repeatsEntireArray() {
        assertArrayEquals(intArrayOf(1, 2, 1, 1, 2, 1), Solution().getConcatenation(intArrayOf(1, 2, 1)))
    }

    @Test
    fun handlesNegativeAndDuplicateValues() {
        assertArrayEquals(intArrayOf(-1, 0, -1, -1, 0, -1), Solution().getConcatenation(intArrayOf(-1, 0, -1)))
    }

    @Test
    fun handlesEmptyArray() {
        assertArrayEquals(intArrayOf(), Solution().getConcatenation(intArrayOf()))
    }
}
