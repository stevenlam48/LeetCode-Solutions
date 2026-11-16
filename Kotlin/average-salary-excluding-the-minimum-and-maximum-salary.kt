package averagesalaryexcludingtheminimumandmaximumsalary

// Time:  O(n)
// Space: O(1)

// one-pass solution
class Solution {
    fun average(salary: IntArray): Double {
        var total = 0L
        var mi = Int.MAX_VALUE
        var ma = Int.MIN_VALUE
        for (s in salary) {
            total += s
            mi = minOf(mi, s)
            ma = maxOf(ma, s)
        }
        return (total - mi - ma).toDouble() / (salary.size - 2)
    }
}
