package querykthsmallesttrimmednumber

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class QueryKthSmallestTrimmedNumberTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val nums = listOf("102", "473", "251", "814")
        val queries = arrayOf(
            intArrayOf(1, 1), intArrayOf(2, 3), intArrayOf(4, 2), intArrayOf(2, 1)
        )
        assertArrayEquals(intArrayOf(2, 2, 1, 0), solution.smallestTrimmedNumbers(nums, queries))
    }

    @Test
    fun testExample2() {
        val nums = listOf("24", "37", "96", "04")
        val queries = arrayOf(intArrayOf(2, 1), intArrayOf(2, 2))
        assertArrayEquals(intArrayOf(3, 0), solution.smallestTrimmedNumbers(nums, queries))
    }

    @Test
    fun testSingleNumber() {
        val nums = listOf("7")
        val queries = arrayOf(intArrayOf(1, 1))
        assertArrayEquals(intArrayOf(0), solution.smallestTrimmedNumbers(nums, queries))
    }

    @Test
    fun testDuplicates() {
        val nums = listOf("11", "11", "11")
        val queries = arrayOf(intArrayOf(1, 2), intArrayOf(3, 2))
        assertArrayEquals(intArrayOf(0, 2), solution.smallestTrimmedNumbers(nums, queries))
    }
}
