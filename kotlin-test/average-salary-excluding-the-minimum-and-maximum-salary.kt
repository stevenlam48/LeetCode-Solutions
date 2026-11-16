package averagesalaryexcludingtheminimumandmaximumsalary

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class AverageSalaryExcludingTheMinimumAndMaximumSalaryTest {
    private val solution = Solution()

    @Test
    fun testExample1() {
        assertEquals(2500.0, solution.average(intArrayOf(4000, 3000, 1000, 2000)), 1e-9)
    }

    @Test
    fun testExample2() {
        assertEquals(2000.0, solution.average(intArrayOf(1000, 2000, 3000)), 1e-9)
    }

    @Test
    fun testThreeElements() {
        assertEquals(2.0, solution.average(intArrayOf(1, 2, 3)), 1e-9)
    }

    @Test
    fun testDuplicateExtremes() {
        assertEquals(2.5, solution.average(intArrayOf(1, 1, 4, 2, 3, 4)), 1e-9)
    }
}
