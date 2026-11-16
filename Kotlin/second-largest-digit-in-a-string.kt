package secondlargestdigitinastring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun secondHighest(s: String): Int {
        var first = -1
        var second = -1
        for (c in s) {
            if (c !in '0'..'9') {
                continue
            }
            val d = c - '0'
            if (d > first) {
                second = first
                first = d
            } else if (first > d && d > second) {
                second = d
            }
        }
        return second
    }
}
