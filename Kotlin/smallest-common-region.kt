package smallestcommonregion

// Time:  O(m * n)
// Space: O(n)

class Solution {
    fun findSmallestRegion(regions: List<List<String>>, region1: String, region2: String): String {
        val parents = HashMap<String, String>()
        for (region in regions) {
            for (i in 1 until region.size) {
                parents[region[i]] = region[0]
            }
        }
        val lookup = HashSet<String>()
        var r1 = region1
        var r2 = region2
        lookup.add(r1)
        while (parents.containsKey(r1)) {
            r1 = parents[r1]!!
            lookup.add(r1)
        }
        while (!lookup.contains(r2)) {
            r2 = parents[r2]!!
        }
        return r2
    }
}
