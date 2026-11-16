package kthdistinctstringinanarray

// Time:  O(n)
// Space: O(n)

class Solution {
    fun kthDistinct(arr: List<String>, k: Int): String {
        val count = HashMap<String, Int>()
        for (s in arr) {
            count[s] = (count[s] ?: 0) + 1
        }
        var remaining = k
        for (s in arr) {
            if (count[s] == 1) {
                --remaining
                if (remaining == 0) {
                    return s
                }
            }
        }
        return ""
    }
}
