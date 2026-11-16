package reducearraysizetothehalf

// Time:  O(n)
// Space: O(n)

class Solution {
    fun minSetSize(arr: IntArray): Int {
        val countingSort = IntArray(arr.size)
        val count = HashMap<Int, Int>()
        for (x in arr) {
            count[x] = (count[x] ?: 0) + 1
        }
        for (c in count.values) {
            ++countingSort[c - 1]
        }
        var result = 0
        var total = 0
        for (c in arr.size - 1 downTo 0) {
            if (countingSort[c] == 0) {
                continue
            }
            val take = minOf(
                countingSort[c],
                ((arr.size + 1) / 2 - total - 1) / (c + 1) + 1
            )
            result += take
            total += take * (c + 1)
            if (total >= (arr.size + 1) / 2) {
                break
            }
        }
        return result
    }
}
