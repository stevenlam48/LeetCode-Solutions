package queriesonapermutationwithkey

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class QueriesOnAPermutationWithKeyTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertArrayEquals(intArrayOf(2, 1, 2, 1), solution.processQueries(intArrayOf(3, 1, 2, 1), 5))
    }

    @Test
    fun testExample2() {
        assertArrayEquals(intArrayOf(3, 1, 2, 0), solution.processQueries(intArrayOf(4, 1, 2, 2), 4))
    }

    @Test
    fun testExample3() {
        assertArrayEquals(
            intArrayOf(6, 5, 0, 7, 5),
            solution.processQueries(intArrayOf(7, 5, 5, 8, 3), 8)
        )
    }

    @Test
    fun testSingleElement() {
        assertArrayEquals(intArrayOf(0), solution.processQueries(intArrayOf(1), 1))
    }
}
