package convert1darrayinto2darray

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class Convert1dArrayInto2dArrayTest {
    @Test
    fun constructTwoByTwoArray() {
        val expected = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        val actual = Solution().construct2DArray(intArrayOf(1, 2, 3, 4), 2, 2)
        assertArrayEquals(expected, actual)
    }

    @Test
    fun constructSingleRow() {
        val expected = arrayOf(intArrayOf(1, 2, 3))
        assertArrayEquals(expected, Solution().construct2DArray(intArrayOf(1, 2, 3), 1, 3))
    }

    @Test
    fun mismatchedDimensionsReturnEmptyArray() {
        assertArrayEquals(emptyArray(), Solution().construct2DArray(intArrayOf(1, 2), 1, 1))
    }

    @Test
    fun emptyInputCanConstructEmptyArray() {
        assertArrayEquals(emptyArray(), Solution().construct2DArray(intArrayOf(), 0, 3))
    }
}
