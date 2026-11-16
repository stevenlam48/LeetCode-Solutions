package peoplewhoselistoffavoritecompaniesisnotasubsetofanotherlist

// Time:  O(n * m * l + n^2 * m), n is favoriteCompanies.length
//                              , m is the max of favoriteCompanies[i].length
//                              , l is the max of favoriteCompanies[i][j].length
// Space: O(n * m * l)

class Solution {
    fun peopleIndexes(favoriteCompanies: List<List<String>>): List<Int> {
        val lookup = HashMap<String, Int>()
        val comps = mutableListOf<HashSet<Int>>()
        for (cs in favoriteCompanies) {
            val set = HashSet<Int>()
            for (c in cs) {
                if (!lookup.containsKey(c)) {
                    val id = lookup.size
                    lookup[c] = id
                }
                set.add(lookup[c]!!)
            }
            comps.add(set)
        }
        val result = mutableListOf<Int>()
        for (i in comps.indices) {
            var isNotSubset = true
            for (j in comps.indices) {
                if (i == j) {
                    continue
                }
                if (comps[i].all { a -> comps[j].contains(a) }) {
                    isNotSubset = false
                    break
                }
            }
            if (isNotSubset) {
                result.add(i)
            }
        }
        return result
    }
}
