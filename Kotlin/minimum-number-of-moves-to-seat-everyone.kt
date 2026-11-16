package minimumnumberofmovestoseateveryone

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
        seats.sort()
        students.sort()
        var result = 0
        for (i in seats.indices) {
            result += Math.abs(seats[i] - students[i])
        }
        return result
    }
}
