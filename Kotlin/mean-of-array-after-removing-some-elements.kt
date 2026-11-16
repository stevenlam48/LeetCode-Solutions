package meanofarrayafterremovingsomeelements
// Time:  O(n)
// Space: O(1)

class Solution {
    fun trimMean(arr: IntArray): Double {
        val k = arr.size / 20
        arr.sort()
        var sum = 0.0
        for (i in k until arr.size - k) {
            sum += arr[i]
        }
        return sum / (arr.size - 2 * k)
    }
}
