package maximumaveragepassratio

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumAveragePassRatioTest {
    private val solution = Solution()

    @Test
    fun firstExample() {
        val classes = arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(2, 2))
        assertEquals(0.7833333333, solution.maxAverageRatio(classes, 2), 1e-5)
    }

    @Test
    fun noExtraStudents() {
        val classes = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3))
        assertEquals(7.0 / 12.0, solution.maxAverageRatio(classes, 0), 1e-5)
    }

    @Test
    fun singleClass() {
        assertEquals(0.5, solution.maxAverageRatio(arrayOf(intArrayOf(0, 5)), 5), 1e-5)
    }

    @Test
    fun alreadyPerfectPassRatio() {
        val classes = arrayOf(intArrayOf(3, 3), intArrayOf(4, 4))
        assertEquals(1.0, solution.maxAverageRatio(classes, 3), 1e-5)
    }

    @Test
    fun oneExtraStudentUsesLargestGain() {
        val classes = arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(2, 2))
        assertEquals(0.7555555556, solution.maxAverageRatio(classes, 1), 1e-5)
    }
}
