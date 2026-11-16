package getbiggestthreerhombussumsinagrid

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class GetBiggestThreeRhombusSumsInAGridTest {
    @Test
    fun `five by five example`() {
        val grid = arrayOf(
            intArrayOf(3, 4, 5, 1, 3),
            intArrayOf(3, 3, 4, 2, 3),
            intArrayOf(20, 30, 200, 40, 10),
            intArrayOf(1, 5, 5, 4, 1),
            intArrayOf(4, 3, 2, 2, 5)
        )
        assertArrayEquals(intArrayOf(228, 216, 211), Solution().getBiggestThree(grid))
    }

    @Test
    fun `three by three example`() {
        val grid = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
        assertArrayEquals(intArrayOf(20, 9, 8), Solution().getBiggestThree(grid))
    }

    @Test
    fun `single cell and duplicate sums`() {
        assertArrayEquals(intArrayOf(7), Solution().getBiggestThree(arrayOf(intArrayOf(7))))
        val grid = arrayOf(intArrayOf(5, 5), intArrayOf(5, 5))
        assertArrayEquals(intArrayOf(5), Solution().getBiggestThree(grid))
    }
}
