package singlenumberiii

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SingleNumberIiiTest {
    private val solution = Solution()

    @Test
    fun `two unpaired values`() {
        assertArrayEquals(intArrayOf(3, 5), solution.singleNumber(intArrayOf(1, 2, 1, 3, 2, 5)).sortedArray())
    }

    @Test
    fun `negative and zero values`() {
        assertArrayEquals(intArrayOf(-1, 0), solution.singleNumber(intArrayOf(-1, 0)).sortedArray())
    }

    @Test
    fun `zero and positive values`() {
        assertArrayEquals(intArrayOf(0, 1), solution.singleNumber(intArrayOf(0, 1)).sortedArray())
    }

    @Test
    fun `integer minimum`() {
        assertArrayEquals(intArrayOf(Int.MIN_VALUE, 0), solution.singleNumber(intArrayOf(Int.MIN_VALUE, 0)).sortedArray())
    }
}
