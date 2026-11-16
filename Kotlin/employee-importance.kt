package employeeimportance
// Time:  O(n)
// Space: O(h)

class Employee(
    var id: Int = 0,
    var importance: Int = 0,
    var subordinates: List<Int> = emptyList()
)

class Solution {
    fun getImportance(employees: List<Employee?>, id: Int): Int {
        return dfs(employees, id)
    }

    private fun dfs(employees: List<Employee?>, id: Int): Int {
        val employee = employees[id - 1] ?: return 0
        var result = employee.importance
        for (subordinateId in employee.subordinates) {
            result += getImportance(employees, subordinateId)
        }
        return result
    }
}
