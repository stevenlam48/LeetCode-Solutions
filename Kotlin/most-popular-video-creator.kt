package mostpopularvideocreator
// Time:  O(n)
// Space: O(n)

class Solution {
    fun mostPopularCreator(creators: Array<String>, ids: Array<String>, views: IntArray): List<List<String>> {
        val cnt = HashMap<String, Long>()
        val lookup = HashMap<String, Pair<Int, String>>()
        for (i in creators.indices) {
            cnt[creators[i]] = cnt.getOrDefault(creators[i], 0L) + views[i]
            val candidate = -views[i] to ids[i]
            val current = lookup[creators[i]]
            if (current == null || candidate.first < current.first ||
                (candidate.first == current.first && candidate.second < current.second)
            ) {
                lookup[creators[i]] = candidate
            }
        }
        var mx = 0L
        for (value in cnt.values) {
            mx = maxOf(mx, value)
        }
        val result = mutableListOf<List<String>>()
        for ((creator, value) in cnt) {
            if (value == mx) {
                result.add(listOf(creator, lookup.getValue(creator).second))
            }
        }
        return result
    }
}
