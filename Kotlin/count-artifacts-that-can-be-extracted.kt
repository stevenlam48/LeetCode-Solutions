package countartifactsthatcanbeextracted

// Time:  O(a + d), a is the number of grids covered by artifacts, d is the size of dig
// Space: O(d)

class Solution {
    fun digArtifacts(n: Int, artifacts: Array<IntArray>, dig: Array<IntArray>): Int {
        val lookup = HashSet<Int>()
        for (x in dig) {
            lookup.add(x[0] * n + x[1])
        }
        var result = 0
        for (x in artifacts) {
            var cnt = (x[2] - x[0] + 1) * (x[3] - x[1] + 1)
            for (i in x[0]..x[2]) {
                for (j in x[1]..x[3]) {
                    if (lookup.contains(i * n + j)) {
                        --cnt
                    }
                }
            }
            if (cnt == 0) {
                ++result
            }
        }
        return result
    }
}
