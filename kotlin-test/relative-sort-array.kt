package relativesortarray

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class RelativeSortArrayTest {
    @Test
    fun standardExample() {
        val arr1 = intArrayOf(2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19)
        val arr2 = intArrayOf(2, 1, 4, 3, 9, 6)
        assertArrayEquals(intArrayOf(2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19), Solution().relativeSortArray(arr1, arr2))
    }

    @Test
    fun allValuesAreRemainingValues() {
        val arr1 = intArrayOf(5, 1, 3)
        assertArrayEquals(intArrayOf(1, 3, 5), Solution().relativeSortArray(arr1, intArrayOf()))
    }

    @Test
    fun duplicateValues() {
        val arr1 = intArrayOf(4, 2, 4, 1, 2)
        val arr2 = intArrayOf(2, 4)
        assertArrayEquals(intArrayOf(2, 2, 4, 4, 1), Solution().relativeSortArray(arr1, arr2))
    }
}
