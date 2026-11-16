package minimumbitwiseorfromgrid

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumBitwiseOrFromGridTest {
    @Test
    fun chooseAcrossRows() = assertEquals(2, Solution().minimumOR(arrayOf(intArrayOf(1, 2), intArrayOf(2, 4))))

    @Test
    fun secondGrid() = assertEquals(3, Solution().minimumOR(arrayOf(intArrayOf(3, 5), intArrayOf(1, 6))))

    @Test
    fun oneValuePerRow() = assertEquals(7, Solution().minimumOR(arrayOf(intArrayOf(3), intArrayOf(4))))

    @Test
    fun allZeros() = assertEquals(0, Solution().minimumOR(arrayOf(intArrayOf(0, 0), intArrayOf(0))))
}
