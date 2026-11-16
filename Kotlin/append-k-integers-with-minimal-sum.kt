package appendkintegerswithminimalsum

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun minimalKSum(nums: IntArray, k: Int): Long {
        var result = k.toLong() * (k + 1) / 2
        var curr = k + 1
        for (x in nums.toSortedSet()) {
            if (x < curr) {
                result += (curr++ - x).toLong()
            }
        }
        return result
    }
}
