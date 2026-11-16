package employeeimportance

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EmployeeImportanceTest {
    private val solution = Solution()

    @Test
    fun `sums manager and all direct subordinates`() {
        val employees = listOf(
            Employee(1, 5, listOf(2, 3)),
            Employee(2, 3),
            Employee(3, 3)
        )

        assertEquals(11, solution.getImportance(employees, 1))
    }

    @Test
    fun `sums a deep reporting chain`() {
        val employees = listOf(
            Employee(1, 2, listOf(2)),
            Employee(2, 4, listOf(3)),
            Employee(3, 8)
        )

        assertEquals(14, solution.getImportance(employees, 1))
        assertEquals(12, solution.getImportance(employees, 2))
        assertEquals(8, solution.getImportance(employees, 3))
    }

    @Test
    fun `supports negative importance values`() {
        val employees = listOf(
            Employee(1, -4, listOf(2, 3)),
            Employee(2, 7),
            Employee(3, -2)
        )

        assertEquals(1, solution.getImportance(employees, 1))
    }

    @Test
    fun `missing employee entry contributes zero`() {
        val employees = listOf(Employee(1, 6, listOf(2)), null)

        assertEquals(0, solution.getImportance(employees, 2))
        assertEquals(6, solution.getImportance(employees, 1))
    }
}
