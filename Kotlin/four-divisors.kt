package fourdivisors

// Time:  O(n * sqrt(n))
// Space: O(1)

class Solution {
    fun sumFourDivisors(nums: IntArray): Int {
        var result = 0
        for (num in nums) {
            val facs = mutableListOf<Int>()
            var i = 1
            while (i * i <= num) {
                if (num % i != 0) {
                    ++i
                    continue
                }
                facs.add(i)
                if (i != num / i) {
                    facs.add(num / i)
                    if (facs.size > 4) {
                        break
                    }
                }
                ++i
            }
            if (facs.size == 4) {
                result += facs.sum()
            }
        }
        return result
    }
}
