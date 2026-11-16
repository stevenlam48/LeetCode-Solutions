package findthewinnerofanarraygame

// Time:  O(n)
// Space: O(1)

class Solution {
    fun getWinner(arr: IntArray, k: Int): Int {
        var result = arr[0]
        var count = 0
        for (i in 1 until arr.size) {
            if (arr[i] > result) {
                result = arr[i]
                count = 0
            }
            if (++count == k) {
                break
            }
        }
        return result
    }
}
