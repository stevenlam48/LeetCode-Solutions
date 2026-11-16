package subsetsii

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SubsetsIiTest {
    @Test
    fun testExample1() {
        val expected = listOf(
            emptyList<Int>(),
            listOf(1),
            listOf(2),
            listOf(1, 2),
            listOf(2, 2),
            listOf(1, 2, 2)
        )
        assertEquals(expected, Solution().subsetsWithDup(intArrayOf(1, 2, 2)))
    }

    @Test
    fun testExample2() {
        val expected = listOf(emptyList<Int>(), listOf(0))
        assertEquals(expected, Solution().subsetsWithDup(intArrayOf(0)))
    }

    @Test
    fun testAllSame() {
        val expected = listOf(
            emptyList<Int>(),
            listOf(1),
            listOf(1, 1),
            listOf(1, 1, 1)
        )
        assertEquals(expected, Solution().subsetsWithDup(intArrayOf(1, 1, 1)))
    }

    @Test
    fun testAllDistinct() {
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
        assertEquals(expected, Solution().subsetsWithDup(intArrayOf(3, 1, 2)))
    }

    @Test
    fun testEmpty() {
        assertEquals(listOf(emptyList<Int>()), Solution().subsetsWithDup(intArrayOf()))
    }
}
