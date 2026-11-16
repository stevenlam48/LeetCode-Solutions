package countallpossibleroutes

// Time:  O(nlogn + n * f)
// Space: O(n * f)

class Solution {
    fun countRoutes(locations: IntArray, start: Int, finish: Int, fuel: Int): Int {
        val MOD = 1_000_000_007

        val s = locations[start]
        val f = locations[finish]
        locations.sort()
        val startIdx = locations.indexOf(s)
        val finishIdx = locations.indexOf(f)

        val n = locations.size
        val left = Array(n) { IntArray(fuel + 1) }
        val right = Array(n) { IntArray(fuel + 1) }
        for (fu in 1..fuel) {
            for (j in 0 until n - 1) {
                val d = locations[j + 1] - locations[j]
                if (fu > d) {
                    left[j][fu] = (right[j + 1][fu - d] + 2 * left[j + 1][fu - d] % MOD) % MOD
                } else if (fu == d) {
                    left[j][fu] = if (j + 1 == startIdx) 1 else 0
                }
            }
            for (j in 1 until n) {
                val d = locations[j] - locations[j - 1]
                if (fu > d) {
                    right[j][fu] = (left[j - 1][fu - d] + 2 * right[j - 1][fu - d] % MOD) % MOD
                } else if (fu == d) {
                    right[j][fu] = if (j - 1 == startIdx) 1 else 0
                }
            }
        }
        var result = if (startIdx == finishIdx) 1 else 0
        for (fu in 1..fuel) {
            result = ((result + left[finishIdx][fu]) % MOD + right[finishIdx][fu]) % MOD
        }
        return result
    }
}
