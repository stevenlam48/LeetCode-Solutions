package findallgroupsoffarmland

// Time:  O(m * n)
// Space: O(1)

class Solution {
    fun findFarmland(land: Array<IntArray>): Array<IntArray> {
        val result = mutableListOf<IntArray>()
        for (i in land.indices) {
            for (j in land[0].indices) {
                if (land[i][j] != 1) {
                    continue
                }
                var ni = i
                var nj = j
                while (ni + 1 < land.size && land[ni + 1][j] != 0) {
                    ++ni
                }
                while (nj + 1 < land[0].size && land[i][nj + 1] != 0) {
                    ++nj
                }
                for (r in i..ni) {
                    for (c in j..nj) {
                        land[r][c] = -1
                    }
                }
                result.add(intArrayOf(i, j, ni, nj))
            }
        }
        return result.toTypedArray()
    }
}
