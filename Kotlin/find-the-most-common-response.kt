package findthemostcommonresponse

// Time:  O(n * l)
// Space: O(n * l)

// hash table, freq table
class Solution {
    fun findCommonResponse(responses: List<List<String>>): String {
        val cnt = HashMap<String, Int>()
        for (r in responses) {
            for (x in r.toHashSet()) {
                cnt[x] = (cnt[x] ?: 0) + 1
            }
        }
        var bestCount = -1
        var best = ""
        for ((x, c) in cnt) {
            if (c > bestCount || (c == bestCount && x < best)) {
                bestCount = c
                best = x
            }
        }
        return best
    }
}
