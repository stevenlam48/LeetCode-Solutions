package elevatorrequestsi

// Time:  O(m), m = len(requests)
// Space: O(1)
import kotlin.math.abs

class Solution {
    fun elevatorRequests(n: Int, requests: IntArray): Int {
        var result = requests[0]
        for (i in 0 until requests.size - 1) {
            result += abs(requests[i + 1] - requests[i])
        }
        return result
    }
}
