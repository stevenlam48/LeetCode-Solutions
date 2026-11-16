package sortarrayusingprefixreversals

// Time:  O(n! * n * m)
// Space: O(n! * n)

class Solution {
    fun sortArray(nums: IntArray, pre: IntArray): Int {
        fun encode(arr: IntArray): String {
            val result = StringBuilder(arr.size)
            for (x in arr) {
                result.append(('0'.code + x).toChar())
            }
            return result.toString()
        }

        fun biBfs(start: String, target: String): Int {
            var left = mutableSetOf(start)
            var right = mutableSetOf(target)
            val lookup = mutableSetOf<String>()
            var steps = 0
            while (left.isNotEmpty()) {
                if (left.size > right.size) {
                    val temp = left
                    left = right
                    right = temp
                }
                lookup.addAll(left)
                val newLeft = mutableSetOf<String>()
                for (value in left) {
                    if (right.contains(value)) {
                        return steps
                    }
                    val chars = value.toCharArray()
                    for (i in pre) {
                        chars.reversePrefix(i)
                        val next = String(chars)
                        if (!lookup.contains(next)) {
                            newLeft.add(next)
                        }
                        chars.reversePrefix(i)
                    }
                }
                left = newLeft
                ++steps
            }
            return -1
        }

        val arr = IntArray(nums.size) { it }
        return biBfs(encode(nums), encode(arr))
    }

    private fun CharArray.reversePrefix(length: Int) {
        var left = 0
        var right = length - 1
        while (left < right) {
            val temp = this[left]
            this[left] = this[right]
            this[right] = temp
            ++left
            --right
        }
    }
}
