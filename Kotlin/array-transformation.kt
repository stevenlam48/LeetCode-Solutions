package arraytransformation

// Time:  O(n^2)
// Space: O(n)

class Solution {
    fun transformArray(arr: IntArray): IntArray {
        var current = arr
        while (isChangable(current)) {
            val newArr = current.copyOf()
            var i = 1
            while (i + 1 < current.size) {
                if (current[i - 1] > current[i] && current[i] < current[i + 1]) {
                    ++newArr[i]
                }
                if (current[i - 1] < current[i] && current[i] > current[i + 1]) {
                    --newArr[i]
                }
                ++i
            }
            current = newArr
        }
        return current
    }

    private fun isChangable(arr: IntArray): Boolean {
        var i = 1
        while (i + 1 < arr.size) {
            if ((arr[i - 1] > arr[i] && arr[i] < arr[i + 1]) ||
                (arr[i - 1] < arr[i] && arr[i] > arr[i + 1])) {
                return true
            }
            ++i
        }
        return false
    }
}
