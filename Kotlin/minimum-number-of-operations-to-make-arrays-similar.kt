package minimumnumberofoperationstomakearrayssimilar

// Time:  O(nlogn)
// Space: O(1)

// greedy, sort
class Solution {
    fun makeSimilar(nums: IntArray, target: IntArray): Long {
        val cmp = Comparator<Int> { a, b ->
            val pa = a % 2
            val pb = b % 2
            if (pa != pb) pa.compareTo(pb) else a.compareTo(b)
        }
        val a = nums.sortedWith(cmp)
        val b = target.sortedWith(cmp)
        var result = 0L
        for (i in a.indices) {
            result += Math.abs(a[i].toLong() - b[i].toLong()) / 2
        }
        return result / 2
    }
}
