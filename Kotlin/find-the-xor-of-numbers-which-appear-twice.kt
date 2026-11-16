package findthexorofnumberswhichappeartwice

// Time:  O(n)
// Space: O(n)

// hash table
class Solution {
    fun duplicateNumbersXOR(nums: IntArray): Int {
        var result = 0
        val lookup = HashSet<Int>()
        for (x in nums) {
            result = result xor x
            if (lookup.contains(x)) {
                continue
            }
            lookup.add(x)
            result = result xor x
        }
        return result
    }
}
