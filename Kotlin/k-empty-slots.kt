package kemptyslots
// Time:  O(n)
// Space: O(n)

class Solution {
    fun kEmptySlots(flowers: IntArray, k: Int): Int {
        val days = IntArray(flowers.size)
        for (i in flowers.indices) {
            days[flowers[i] - 1] = i
        }
        var result = Int.MAX_VALUE
        var left = 0
        var right = k + 1
        var i = 0
        while (right < days.size) {
            if (days[i] < days[left] || days[i] <= days[right]) {
                if (i == right) {
                    result = minOf(result, maxOf(days[left], days[right]))
                }
                left = i
                right = k + 1 + i
            }
            ++i
        }
        return if (result == Int.MAX_VALUE) -1 else result + 1
    }
}
