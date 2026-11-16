package sortintegersbybinaryreflection

// Time:  O(nlogr + nlogn)
// Space: O(n)

class Solution {
    fun sortByReflection(nums: IntArray): IntArray {
        fun reverse(value: Int): Int {
            var x = value
            var result = 0
            while (x != 0) {
                result = (result shl 1) or (x and 1)
                x = x shr 1
            }
            return result
        }

        val pairs = Array(nums.size) { i -> reverse(nums[i]) to nums[i] }
        pairs.sortWith(compareBy<Pair<Int, Int>> { it.first }.thenBy { it.second })
        return IntArray(nums.size) { i -> pairs[i].second }
    }
}
