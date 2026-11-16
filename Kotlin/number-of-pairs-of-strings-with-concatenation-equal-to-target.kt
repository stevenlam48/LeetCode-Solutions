package numberofpairsofstringswithconcatenationequaltotarget

// Time:  O(n * l), n is the size of nums, l is the average length of the digit string in nums
// Space: O(n)

class Solution {
    fun numOfPairs(nums: List<String>, target: String): Int {
        val lookup = HashMap<Int, Int>()
        var result = 0
        for (num in nums) {
            if (num.length > target.length) {
                continue
            }
            val difference = target.length - num.length
            val cnt1 = lookup[-difference] ?: 0
            val cnt2 = lookup[difference] ?: 0
            if (target.startsWith(num)) {
                result += cnt1
                lookup[num.length] = (lookup[num.length] ?: 0) + 1
            }
            if (target.endsWith(num)) {
                result += cnt2
                lookup[-num.length] = (lookup[-num.length] ?: 0) + 1
            }
        }
        return result
    }
}
