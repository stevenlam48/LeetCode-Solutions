package findallnumbersdisappearedinanarrayii

// Time:  O(r)
// Space: O(r)

class Solution {
    fun findDisappearedNumbers(nums: IntArray, lower: Int, upper: Int): Array<IntArray> {
        val lookup = BooleanArray(upper - lower + 1)
        for (x in nums) {
            if (x !in lower..upper) {
                continue
            }
            lookup[x - lower] = true
        }
        val result = ArrayList<IntArray>()
        var length = 0
        for (i in lookup.indices) {
            ++length
            if (i + 1 == lookup.size || lookup[i + 1] != lookup[i]) {
                if (!lookup[i]) {
                    result.add(intArrayOf(lower + (i - length + 1), lower + i))
                }
                length = 0
            }
        }
        return result.toTypedArray()
    }
}
