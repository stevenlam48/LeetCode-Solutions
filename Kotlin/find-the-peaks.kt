package findthepeaks
// Time:  O(n)
// Space: O(1)

class Solution {
    fun findPeaks(mountain: IntArray): IntArray {
        val result = mutableListOf<Int>()
        for (i in 1 until mountain.lastIndex) {
            if (mountain[i - 1] < mountain[i] && mountain[i] > mountain[i + 1]) {
                result.add(i)
            }
        }
        return result.toIntArray()
    }
}
