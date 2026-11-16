package duplicatezeros

// Time:  O(n)
// Space: O(1)

class Solution {
    fun duplicateZeros(arr: IntArray) {
        var shift = 0
        var i = 0
        while (i + shift < arr.size) {
            if (arr[i] == 0) {
                shift += 1
            }
            ++i
        }
        i = i - 1
        while (shift > 0) {
            if (i + shift < arr.size) {
                arr[i + shift] = arr[i]
            }
            if (arr[i] == 0) {
                --shift
                arr[i + shift] = arr[i]
            }
            --i
        }
    }
}
