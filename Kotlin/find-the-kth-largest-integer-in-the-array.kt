package findthekthlargestintegerinthearray

// Time:  O(n) ~ O(n^2), O(n) on average
// Space: O(1)

class Solution {
    fun kthLargestNumber(nums: Array<String>, k: Int): String {
        val cmp = Comparator<String> { a, b ->
            if (a.length == b.length) b.compareTo(a) else b.length - a.length
        }
        return nums.sortedWith(cmp)[k - 1]
    }
}
