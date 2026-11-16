package rangeproductqueriesofpowers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RangeProductQueriesOfPowersTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        val queries = arrayOf(intArrayOf(0, 1), intArrayOf(2, 2), intArrayOf(0, 3))
        assertArrayEquals(intArrayOf(2, 4, 64), solution.productQueries(15, queries))
    }

    @Test
    fun testExample2() {
        val queries = arrayOf(intArrayOf(0, 0))
        assertArrayEquals(intArrayOf(2), solution.productQueries(2, queries))
    }

    @Test
    fun testSingleBit() {
        val queries = arrayOf(intArrayOf(0, 0))
        assertArrayEquals(intArrayOf(1), solution.productQueries(1, queries))
    }

    @Test
    fun testAllBits() {
        val queries = arrayOf(intArrayOf(0, 2))
        assertArrayEquals(intArrayOf(8), solution.productQueries(7, queries))
    }
}
