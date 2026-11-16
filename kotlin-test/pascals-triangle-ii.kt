package pascalstriangleii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class PascalsTriangleIITest {
    private val solution = Solution()

    @Test
    fun returnsFourthRowByZeroBasedIndex() {
        assertArrayEquals(intArrayOf(1, 3, 3, 1), solution.getRow(3))
    }

    @Test
    fun returnsTopRow() {
        assertArrayEquals(intArrayOf(1), solution.getRow(0))
    }

    @Test
    fun returnsFifthRow() {
        assertArrayEquals(intArrayOf(1, 4, 6, 4, 1), solution.getRow(4))
    }
}
