package makingfilenamesunique

// Time:  O(n)
// Space: O(n)

class Solution {
    fun getFolderNames(names: Array<String>): List<String> {
        val count = HashMap<String, Int>()
        val result = ArrayList<String>()
        val lookup = HashSet<String>()
        for (name in names) {
            var c = count[name] ?: 0
            var nameWithSuffix: String
            do {
                nameWithSuffix = if (c != 0) "$name($c)" else name
                ++c
            } while (nameWithSuffix in lookup)
            count[name] = c
            result.add(nameWithSuffix)
            lookup.add(nameWithSuffix)
        }
        return result
    }
}
