package maximumstudentsonasinglebench

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumStudentsOnASingleBenchTest {
    @Test
    fun example1() {
        val students = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 2),
            intArrayOf(3, 3),
            intArrayOf(1, 3),
            intArrayOf(2, 3)
        )
        assertEquals(3, Solution().maxStudentsOnBench(students))
    }

    @Test
    fun oneBench() {
        val students = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 1),
            intArrayOf(3, 1)
        )
        assertEquals(3, Solution().maxStudentsOnBench(students))
    }

    @Test
    fun singleStudent() {
        assertEquals(1, Solution().maxStudentsOnBench(arrayOf(intArrayOf(1, 1))))
    }

    @Test
    fun duplicateEntries() {
        val students = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )
        assertEquals(1, Solution().maxStudentsOnBench(students))
    }

    @Test
    fun manyOnOneBench() {
        val students = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 2),
            intArrayOf(3, 2),
            intArrayOf(4, 2)
        )
        assertEquals(4, Solution().maxStudentsOnBench(students))
    }
}
