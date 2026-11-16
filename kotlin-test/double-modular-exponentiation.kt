package doublemodularexponentiation

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DoubleModularExponentiationTest {
    @Test
    fun example1() {
        val variables = arrayOf(
            intArrayOf(2, 3, 3, 10),
            intArrayOf(3, 3, 3, 1),
            intArrayOf(6, 1, 1, 4)
        )
        assertArrayEquals(intArrayOf(0, 2), Solution().getGoodIndices(variables, 2))
    }

    @Test
    fun example2() {
        val variables = arrayOf(intArrayOf(39, 3, 1000, 1000))
        assertArrayEquals(intArrayOf(), Solution().getGoodIndices(variables, 17))
    }

    @Test
    fun simpleMatch() {
        val variables = arrayOf(intArrayOf(1, 1, 1, 2))
        assertArrayEquals(intArrayOf(0), Solution().getGoodIndices(variables, 1))
    }

    @Test
    fun multipleMatches() {
        val variables = arrayOf(
            intArrayOf(2, 2, 2, 3),
            intArrayOf(1, 1, 1, 2),
            intArrayOf(3, 3, 3, 1)
        )
        assertArrayEquals(intArrayOf(0, 1), Solution().getGoodIndices(variables, 1))
    }
}
