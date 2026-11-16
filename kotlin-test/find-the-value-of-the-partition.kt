package findthevalueofthepartition

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindTheValueOfThePartitionTest {

    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(1, solution.findValueOfPartition(intArrayOf(1, 3, 2, 4)))
    }

    @Test
    fun testExample2() {
        assertEquals(9, solution.findValueOfPartition(intArrayOf(100, 1, 10)))
    }

    @Test
    fun testTwoElements() {
        assertEquals(7, solution.findValueOfPartition(intArrayOf(10, 3)))
    }

    @Test
    fun testDuplicates() {
        assertEquals(0, solution.findValueOfPartition(intArrayOf(5, 5, 5)))
    }

    @Test
    fun testNegatives() {
        assertEquals(1, solution.findValueOfPartition(intArrayOf(-1, 0, 2)))
    }
}
