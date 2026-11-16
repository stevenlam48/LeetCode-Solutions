package maximumstudentsonasinglebench

// Time:  O(n)
// Space: O(n)

class Solution {
    fun maxStudentsOnBench(students: Array<IntArray>): Int {
        val lookup = HashMap<Int, HashSet<Int>>()
        for (x in students) {
            lookup.getOrPut(x[1]) { HashSet() }.add(x[0])
        }
        var result = 0
        for (v in lookup.values) {
            result = maxOf(result, v.size)
        }
        return result
    }
}
