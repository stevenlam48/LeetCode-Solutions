package replaceelementswithgreatestelementonrightside
// Time:  O(n)
// Space: O(1)

class Solution {
    fun replaceElements(arr: IntArray): IntArray {
        var currMax = -1
        for (i in arr.indices.reversed()) {
            val value = arr[i]
            arr[i] = currMax
            currMax = maxOf(currMax, value)
        }
        return arr
    }
}
