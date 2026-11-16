package scorevalidator

// Time:  O(n)
// Space: O(1)

class Solution {
    fun scoreValidator(events: List<String>): IntArray {
        val result = IntArray(2)
        for (x in events) {
            if (x == "W") {
                if (++result[1] == 10) {
                    break
                }
            } else if (x == "WD" || x == "NB") {
                ++result[0]
            } else {
                result[0] += x[0] - '0'
            }
        }
        return result
    }
}
