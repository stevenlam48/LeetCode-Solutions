package numberofstudentsunabletoeatlunch
// Time:  O(n)
// Space: O(1)

class Solution {
    fun countStudents(students: IntArray, sandwiches: IntArray): Int {
        val count = IntArray(2)
        for (student in students) {
            ++count[student]
        }
        var i = 0
        while (i < sandwiches.size && count[sandwiches[i]] > 0) {
            --count[sandwiches[i]]
            ++i
        }
        return sandwiches.size - i
    }
}
