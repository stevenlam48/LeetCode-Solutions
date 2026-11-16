package minimumdeletionstomakestringkspecial
// Time:  O(n + 26)
// Space: O(n + 26)

class Solution {
    fun minimumDeletions(word: String, k: Int): Int {
        val cnt = IntArray(26)
        for (x in word) {
            ++cnt[x - 'a']
        }
        val frequencies = cnt.filter { it != 0 }
        val arr = countingSort(frequencies)
        var result = word.length
        var right = 0
        var prev = -1
        var prefix = 0
        var suffix = word.length
        for (left in arr.indices) {
            if (left + 1 < arr.size && arr[left + 1] == arr[left]) {
                continue
            }
            while (right < arr.size && arr[right] <= arr[left] + k) {
                suffix -= arr[right++]
            }
            result = minOf(result, prefix + suffix - (arr[left] + k) * (arr.size - right))
            prefix += arr[left] * (left - prev)
            prev = left
        }
        return result
    }

    private fun countingSort(arr: List<Int>): IntArray {
        val count = IntArray(arr.max() + 1)
        for (x in arr) {
            ++count[x]
        }
        for (i in 1 until count.size) {
            count[i] += count[i - 1]
        }
        val result = IntArray(arr.size)
        for (i in arr.size - 1 downTo 0) {
            result[--count[arr[i]]] = arr[i]
        }
        return result
    }
}
