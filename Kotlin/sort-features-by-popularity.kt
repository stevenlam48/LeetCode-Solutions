package sortfeaturesbypopularity

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun sortFeatures(features: Array<String>, responses: List<String>): Array<String> {
        val featuresSet = features.toHashSet()
        val order = HashMap<String, Int>()
        for (i in features.indices) {
            order[features[i]] = i
        }
        val freq = HashMap<String, Int>()
        for (response in responses) {
            val words = response.split(' ').filter { it.isNotEmpty() }.toHashSet()
            for (word in words) {
                if (featuresSet.contains(word)) {
                    freq[word] = freq.getOrDefault(word, 0) + 1
                }
            }
        }
        features.sortWith(
            compareByDescending<String> { freq.getOrDefault(it, 0) }
                .thenBy { order.getValue(it) }
        )
        return features
    }
}
