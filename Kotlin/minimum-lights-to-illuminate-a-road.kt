package minimumlightstoilluminatearoad

// Time:  O(n)
// Space: O(n)

class Solution {
    fun minLights(lights: IntArray): Int {
        val ceilDivide = { a: Int, b: Int -> (a + b - 1) / b }

        val diff = IntArray(lights.size + 1)
        for (i in lights.indices) {
            if (lights[i] == 0) {
                continue
            }
            ++diff[maxOf(i - lights[i], 0)]
            --diff[minOf(i + lights[i], lights.size - 1) + 1]
        }
        var result = 0
        var curr = 0
        var cnt = 0
        for (i in diff.indices) {
            curr += diff[i]
            if (i + 1 == diff.size || curr != 0) {
                result += ceilDivide(cnt, 3)
                cnt = 0
            } else {
                ++cnt
            }
        }
        return result
    }
}
