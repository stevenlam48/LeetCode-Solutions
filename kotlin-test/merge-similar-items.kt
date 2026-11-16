package mergesimilaritems

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MergeSimilarItemsTest {
    @Test
    fun exampleOne() {
        val items1 = arrayOf(intArrayOf(1, 1), intArrayOf(4, 5), intArrayOf(3, 8))
        val items2 = arrayOf(intArrayOf(3, 1), intArrayOf(1, 5))
        val expected = arrayOf(intArrayOf(1, 6), intArrayOf(3, 9), intArrayOf(4, 5))
        assertArrayEquals(expected, Solution().mergeSimilarItems(items1, items2))
    }

    @Test
    fun exampleTwo() {
        val items1 = arrayOf(intArrayOf(1, 1), intArrayOf(3, 2), intArrayOf(2, 3))
        val items2 = arrayOf(intArrayOf(2, 1), intArrayOf(3, 2), intArrayOf(1, 3))
        val expected = arrayOf(intArrayOf(1, 4), intArrayOf(2, 4), intArrayOf(3, 4))
        assertArrayEquals(expected, Solution().mergeSimilarItems(items1, items2))
    }

    @Test
    fun repeatedValuesWithinOneInput() {
        val items1 = arrayOf(intArrayOf(2, 3), intArrayOf(2, 4), intArrayOf(1, 2))
        val items2 = arrayOf(intArrayOf(2, 5))
        assertArrayEquals(arrayOf(intArrayOf(1, 2), intArrayOf(2, 12)), Solution().mergeSimilarItems(items1, items2))
    }

    @Test
    fun emptyInputs() {
        assertArrayEquals(emptyArray(), Solution().mergeSimilarItems(emptyArray(), emptyArray()))
    }
}
