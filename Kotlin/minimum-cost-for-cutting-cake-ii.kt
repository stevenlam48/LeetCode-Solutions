package minimumcostforcuttingcakeii

// Time:  O(mlogm + nlogn)
// Space: O(1)

class Solution {
    fun minimumCost(m: Int, n: Int, horizontalCut: IntArray, verticalCut: IntArray): Long {
        horizontalCut.sort()
        verticalCut.sort()
        var result = 0L
        var i = horizontalCut.size - 1
        var j = verticalCut.size - 1
        var cntH = 1
        var cntV = 1
        while (i >= 0 || j >= 0) {
            if (j < 0 || (i >= 0 && horizontalCut[i] > verticalCut[j])) {
                result += horizontalCut[i].toLong() * cntH
                --i
                ++cntV
            } else {
                result += verticalCut[j].toLong() * cntV
                --j
                ++cntH
            }
        }
        return result
    }
}
