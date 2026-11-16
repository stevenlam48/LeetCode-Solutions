package sumofevennumbersafterqueries

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SumOfEvenNumbersAfterQueriesTest {
    @Test
    fun exampleOne() {
        val queries = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(-3, 1),
            intArrayOf(-4, 0),
            intArrayOf(2, 3)
        )
        assertArrayEquals(intArrayOf(8, 6, 2, 4), Solution().sumEvenAfterQueries(intArrayOf(1, 2, 3, 4), queries))
    }

    @Test
    fun singleElement() {
        assertArrayEquals(intArrayOf(2), Solution().sumEvenAfterQueries(intArrayOf(1), arrayOf(intArrayOf(1, 0))))
    }

    @Test
    fun negatives() {
        val queries = arrayOf(intArrayOf(-1, 0), intArrayOf(-3, 1))
        assertArrayEquals(
            intArrayOf(0, -2),
            Solution().sumEvenAfterQueries(intArrayOf(2, 1), queries)
        )
    }
}
