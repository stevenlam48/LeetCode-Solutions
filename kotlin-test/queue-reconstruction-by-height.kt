package queuereconstructionbyheight

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class QueueReconstructionByHeightTest {
    private val solution = Solution()

    private fun toList(a: List<IntArray>): List<List<Int>> = a.map { it.toList() }

    @Test
    fun testExample1() {
        val people = arrayOf(
            intArrayOf(7, 0), intArrayOf(4, 4), intArrayOf(7, 1),
            intArrayOf(5, 0), intArrayOf(6, 1), intArrayOf(5, 2)
        )
        val expected = listOf(
            listOf(5, 0), listOf(7, 0), listOf(5, 2),
            listOf(6, 1), listOf(4, 4), listOf(7, 1)
        )
        assertEquals(expected, toList(solution.reconstructQueue(people)))
    }

    @Test
    fun testExample2() {
        val people = arrayOf(
            intArrayOf(6, 0), intArrayOf(5, 0), intArrayOf(4, 0),
            intArrayOf(3, 2), intArrayOf(2, 2), intArrayOf(1, 4)
        )
        val expected = listOf(
            listOf(4, 0), listOf(5, 0), listOf(2, 2),
            listOf(3, 2), listOf(1, 4), listOf(6, 0)
        )
        assertEquals(expected, toList(solution.reconstructQueue(people)))
    }

    @Test
    fun testSinglePerson() {
        val people = arrayOf(intArrayOf(5, 0))
        assertEquals(listOf(listOf(5, 0)), toList(solution.reconstructQueue(people)))
    }

    @Test
    fun testSameHeight() {
        val people = arrayOf(intArrayOf(5, 0), intArrayOf(5, 1), intArrayOf(5, 2))
        val expected = listOf(listOf(5, 0), listOf(5, 1), listOf(5, 2))
        assertEquals(expected, toList(solution.reconstructQueue(people)))
    }
}
