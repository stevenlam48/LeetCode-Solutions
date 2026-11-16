package coursescheduleiii

// Time:  O(nlogn)
// Space: O(k), k is the number of courses you can take

import java.util.PriorityQueue

class Solution {
    fun scheduleCourse(courses: Array<IntArray>): Int {
        courses.sortWith(compareBy { it[1] })
        val maxHeap = PriorityQueue<Int>(compareByDescending { it })
        var now = 0
        for (course in courses) {
            maxHeap.add(course[0])
            now += course[0]
            if (now > course[1]) {
                now -= maxHeap.remove()
            }
        }
        return maxHeap.size
    }
}
