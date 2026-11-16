package findoriginalarrayfromdoubledarray

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class FindOriginalArrayFromDoubledArrayTest {
    private val solution = Solution()

    @Test
    fun exampleOne() {
        assertArrayEquals(intArrayOf(1, 3, 4), solution.findOriginalArray(intArrayOf(1, 3, 4, 2, 6, 8)))
    }

    @Test
    fun exampleInvalid() {
        assertArrayEquals(intArrayOf(), solution.findOriginalArray(intArrayOf(6, 3, 0, 1)))
    }

    @Test
    fun oddLength() {
        assertArrayEquals(intArrayOf(), solution.findOriginalArray(intArrayOf(1)))
    }

    @Test
    fun zerosAndRepeatedValues() {
        assertArrayEquals(intArrayOf(0, 0), solution.findOriginalArray(intArrayOf(0, 0, 0, 0)))
        assertArrayEquals(intArrayOf(0, 1), solution.findOriginalArray(intArrayOf(0, 0, 2, 1)))
    }
}
