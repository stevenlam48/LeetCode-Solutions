package transformarraybyparity

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class TransformArrayByParityTest {
    @Test
    fun mixedValues() {
        assertArrayEquals(intArrayOf(0, 0, 1, 1), Solution().transformArray(intArrayOf(4, 3, 2, 1)))
    }

    @Test
    fun allOdd() {
        assertArrayEquals(intArrayOf(1, 1, 1), Solution().transformArray(intArrayOf(1, 3, 5)))
    }

    @Test
    fun allEven() {
        assertArrayEquals(intArrayOf(0, 0), Solution().transformArray(intArrayOf(2, 4)))
    }

    @Test
    fun emptyArray() {
        assertArrayEquals(intArrayOf(), Solution().transformArray(intArrayOf()))
    }

    @Test
    fun negativeValues() {
        assertArrayEquals(intArrayOf(0, 1, 1), Solution().transformArray(intArrayOf(-2, -3, 7)))
    }
}
