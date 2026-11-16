package countsequencestok

// Time:  O(3^(n/2))
// Space: O(3^(n/2))

class Solution {
    private data class Exponents(val two: Int, val three: Int, val five: Int)

    private val lookup = mapOf(
        1 to Exponents(0, 0, 0),
        2 to Exponents(1, 0, 0),
        3 to Exponents(0, 1, 0),
        4 to Exponents(2, 0, 0),
        5 to Exponents(0, 0, 1),
        6 to Exponents(1, 1, 0)
    )

    fun countSequences(nums: IntArray, k: Long): Int {
        val target = factors(k)
        if (target.two == -1) {
            return 0
        }
        val left = count(nums.copyOfRange(0, nums.size / 2))
        val right = count(nums.copyOfRange(nums.size / 2, nums.size))
        var result = 0
        for ((exponents, value) in left) {
            val complement = Exponents(
                target.two - exponents.two,
                target.three - exponents.three,
                target.five - exponents.five
            )
            result += value * (right[complement] ?: 0)
        }
        return result
    }

    private fun factors(value: Long): Exponents {
        var x = value
        var countTwo = 0
        while (x % 2 == 0L) {
            x /= 2
            ++countTwo
        }
        var countThree = 0
        while (x % 3 == 0L) {
            x /= 3
            ++countThree
        }
        var countFive = 0
        while (x % 5 == 0L) {
            x /= 5
            ++countFive
        }
        return if (x == 1L) Exponents(countTwo, countThree, countFive) else Exponents(-1, -1, -1)
    }

    private fun count(nums: IntArray): HashMap<Exponents, Int> {
        var dp = hashMapOf(Exponents(0, 0, 0) to 1)
        for (x in nums) {
            val newDp = HashMap<Exponents, Int>()
            val delta = lookup.getValue(x)
            for ((exponents, value) in dp) {
                newDp[exponents] = (newDp[exponents] ?: 0) + value
                val multiplied = Exponents(
                    exponents.two + delta.two,
                    exponents.three + delta.three,
                    exponents.five + delta.five
                )
                newDp[multiplied] = (newDp[multiplied] ?: 0) + value
                val divided = Exponents(
                    exponents.two - delta.two,
                    exponents.three - delta.three,
                    exponents.five - delta.five
                )
                newDp[divided] = (newDp[divided] ?: 0) + value
            }
            dp = newDp
        }
        return dp
    }
}
