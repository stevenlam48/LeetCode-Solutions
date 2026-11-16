package constructproductmatrix

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ConstructProductMatrixTest {
    @Test
    fun testExample() {
        val result = Solution().constructProductMatrix(
            arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        )
        assertArrayEquals(arrayOf(intArrayOf(24, 12), intArrayOf(8, 6)), result)
    }

    @Test
    fun testSingleElement() {
        val result = Solution().constructProductMatrix(arrayOf(intArrayOf(5)))
        assertArrayEquals(arrayOf(intArrayOf(1)), result)
    }

    @Test
    fun testModulo() {
        val result = Solution().constructProductMatrix(
            arrayOf(intArrayOf(12345, 2), intArrayOf(3, 4))
        )
        assertArrayEquals(arrayOf(intArrayOf(24, 0), intArrayOf(0, 0)), result)
    }

    @Test
    fun testSingleRow() {
        val result = Solution().constructProductMatrix(
            arrayOf(intArrayOf(2, 3, 4))
        )
        assertArrayEquals(arrayOf(intArrayOf(12, 8, 6)), result)
    }

    @Test
    fun testSingleColumn() {
        val result = Solution().constructProductMatrix(
            arrayOf(intArrayOf(2), intArrayOf(3), intArrayOf(4))
        )
        assertArrayEquals(arrayOf(intArrayOf(12), intArrayOf(8), intArrayOf(6)), result)
    }
}
