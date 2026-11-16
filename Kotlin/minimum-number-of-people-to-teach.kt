package minimumnumberofpeopletoteach

// Time:  O(n * m^2)
// Space: O(n * m)

class Solution {
    fun minimumTeachings(n: Int, languages: Array<IntArray>, friendships: Array<IntArray>): Int {
        val languageSets = languages.map { language ->
            val set = HashSet<Int>()
            for (l in language) {
                set.add(l)
            }
            set
        }
        val candidates = HashSet<Int>()
        for (f in friendships) {
            if (intersect(languageSets[f[0] - 1], languageSets[f[1] - 1]).isEmpty()) {
                candidates.add(f[0] - 1)
                candidates.add(f[1] - 1)
            }
        }
        val count = IntArray(n)
        for (i in candidates) {
            for (l in languageSets[i]) {
                ++count[l - 1]
            }
        }
        return candidates.size - (count.maxOrNull() ?: 0)
    }

    private fun intersect(a: Set<Int>, b: Set<Int>): Set<Int> {
        if (a.size > b.size) {
            return intersect(b, a)
        }
        val result = HashSet<Int>()
        for (x in a) {
            if (x in b) {
                result.add(x)
            }
        }
        return result
    }
}
