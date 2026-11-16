package rearrangearrayelementsbysign
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class RearrangeArrayElementsBySignTest {
    @Test
    fun leetCodeExample() {
        assertArrayEquals(
            intArrayOf(3, -2, 1, -5, 2, -4),
            Solution().rearrangeArray(intArrayOf(3, 1, -2, -5, 2, -4))
        )
        assertArrayEquals(intArrayOf(1, -1), Solution().rearrangeArray(intArrayOf(-1, 1)))
    }

    @Test
    fun preservesRelativeOrderWithinEachSign() {
        assertArrayEquals(
            intArrayOf(1, -3, 4, -1, 2, -2),
            Solution().rearrangeArray(intArrayOf(-3, 1, 4, -1, 2, -2))
        )
    }

    @Test
    fun emptyInput() {
        assertArrayEquals(intArrayOf(), Solution().rearrangeArray(intArrayOf()))
    }
}
