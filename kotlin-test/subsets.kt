package subsets

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SubsetsTest {
    @Test
    fun testExample1() {
        val expected = listOf(
            emptyList<Int>(),
            listOf(1),
            listOf(2),
            listOf(1, 2),
            listOf(3),
            listOf(1, 3),
            listOf(2, 3),
            listOf(1, 2, 3)
        )
        assertEquals(expected, Solution().subsets(intArrayOf(1, 2, 3)))
    }

    @Test
    fun testExample2() {
        val expected = listOf(emptyList<Int>(), listOf(0))
        assertEquals(expected, Solution().subsets(intArrayOf(0)))
    }

    @Test
    fun testEmpty() {
        assertEquals(listOf(emptyList<Int>()), Solution().subsets(intArrayOf()))
    }

    @Test
    fun testUnsortedInput() {
        val expected = listOf(
            emptyList<Int>(),
            listOf(1),
            listOf(2),
            listOf(1, 2)
        )
        assertEquals(expected, Solution().subsets(intArrayOf(2, 1)))
    }

    @Test
    fun testCount() {
        assertEquals(16, Solution().subsets(intArrayOf(1, 2, 3, 4)).size)
    }
}
