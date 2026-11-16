package sortarraybyparity

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SortArrayByParityTest {
    @Test
    fun example1() {
        assertArrayEquals(intArrayOf(2, 4, 3, 1), Solution().sortArrayByParity(intArrayOf(3, 1, 2, 4)))
    }

    @Test
    fun singleElement() {
        assertArrayEquals(intArrayOf(0), Solution().sortArrayByParity(intArrayOf(0)))
    }

    @Test
    fun allOdd() {
        assertArrayEquals(intArrayOf(1, 3, 5), Solution().sortArrayByParity(intArrayOf(1, 3, 5)))
    }

    @Test
    fun allEven() {
        assertArrayEquals(intArrayOf(2, 4, 6), Solution().sortArrayByParity(intArrayOf(2, 4, 6)))
    }

    @Test
    fun negativeValues() {
        assertArrayEquals(intArrayOf(-2, -1), Solution().sortArrayByParity(intArrayOf(-2, -1)))
    }
}
