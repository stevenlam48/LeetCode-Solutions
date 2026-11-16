package specialarrayii

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class SpecialArrayIITest {
    @Test
    fun exampleOne() {
        val queries = arrayOf(intArrayOf(0, 2), intArrayOf(2, 3))
        assertArrayEquals(booleanArrayOf(false, true), Solution().isArraySpecial(intArrayOf(4, 3, 1, 6), queries))
    }

    @Test
    fun exampleTwo() {
        val queries = arrayOf(intArrayOf(0, 4))
        assertArrayEquals(booleanArrayOf(false), Solution().isArraySpecial(intArrayOf(3, 4, 1, 2, 6), queries))
    }

    @Test
    fun singleElementQueries() {
        val queries = arrayOf(intArrayOf(0, 0))
        assertArrayEquals(booleanArrayOf(true), Solution().isArraySpecial(intArrayOf(1), queries))
    }

    @Test
    fun wholeArrayAlternating() {
        val queries = arrayOf(intArrayOf(0, 3), intArrayOf(1, 3), intArrayOf(0, 1))
        assertArrayEquals(
            booleanArrayOf(true, true, true),
            Solution().isArraySpecial(intArrayOf(1, 2, 3, 4), queries)
        )
    }
}
