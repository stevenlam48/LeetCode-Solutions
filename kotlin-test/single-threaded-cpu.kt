package singlethreadedcpu

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SingleThreadedCpuTest {
    private val solution = Solution()

    @Test
    fun `chooses shortest available task`() {
        val tasks = arrayOf(intArrayOf(1, 2), intArrayOf(2, 4), intArrayOf(3, 2), intArrayOf(4, 1))
        assertArrayEquals(intArrayOf(0, 2, 3, 1), solution.getOrder(tasks))
    }

    @Test
    fun `breaks equal processing times by index`() {
        val tasks = arrayOf(
            intArrayOf(7, 10), intArrayOf(7, 12), intArrayOf(7, 5),
            intArrayOf(7, 4), intArrayOf(7, 2)
        )
        assertArrayEquals(intArrayOf(4, 3, 2, 0, 1), solution.getOrder(tasks))
    }

    @Test
    fun `cpu skips idle time`() {
        val tasks = arrayOf(intArrayOf(1, 2), intArrayOf(10, 1), intArrayOf(2, 1))
        assertArrayEquals(intArrayOf(0, 2, 1), solution.getOrder(tasks))
    }

    @Test
    fun `time accumulates beyond integer range`() {
        val tasks = arrayOf(intArrayOf(1, Int.MAX_VALUE), intArrayOf(Int.MAX_VALUE, 1))
        assertArrayEquals(intArrayOf(0, 1), solution.getOrder(tasks))
    }
}
