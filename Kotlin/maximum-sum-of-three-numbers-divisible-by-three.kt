package maximumsumofthreenumbersdivisiblebythree
// Time:  O(n)
// Space: O(1)

class Solution {
    fun maximumSum(nums: IntArray): Int {
        fun add(arr: MutableList<Int>, x0: Int) {
            var x = x0
            for (i in arr.indices) {
                if (x > arr[i]) {
                    val t = arr[i]
                    arr[i] = x
                    x = t
                }
            }
            if (arr.size != 3) {
                arr.add(x)
            }
        }

        val group = Array(3) { mutableListOf<Int>() }
        for (x in nums) {
            add(group[x % 3], x)
        }
        var result = 0
        for (g in group) {
            if (g.size == 3) {
                result = maxOf(result, g.sum())
            }
        }
        if (group[0].isNotEmpty() && group[1].isNotEmpty() && group[2].isNotEmpty()) {
            result = maxOf(result, group[0][0] + group[1][0] + group[2][0])
        }
        return result
    }
}
