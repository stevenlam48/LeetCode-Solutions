package sortvowelsinastring

// Time:  O(n)
// Space: O(1)

class Solution {
    fun sortVowels(s: String): String {
        fun inplaceCountingSort(nums: MutableList<Int>, isReverse: Boolean) {
            if (nums.isEmpty()) {
                return
            }
            val maxNum = nums.max()
            val count = IntArray(maxNum + 1)
            for (num in nums) {
                ++count[num]
            }
            for (i in 1 until count.size) {
                count[i] += count[i - 1]
            }
            for (i in nums.size - 1 downTo 0) {
                while (nums[i] >= 0) {
                    --count[nums[i]]
                    val j = count[nums[i]]
                    val current = nums[i]
                    nums[i] = nums[j]
                    nums[j] = current.inv()
                }
            }
            for (i in nums.indices) {
                nums[i] = nums[i].inv()
            }
            if (isReverse) {
                nums.reverse()
            }
        }

        val lookup = HashMap<Char, Int>()
        for (i in VOWELS.indices) {
            lookup[VOWELS[i]] = i
        }
        val vowels = ArrayList<Int>()
        for (c in s) {
            if (lookup.containsKey(c)) {
                vowels.add(lookup.getValue(c))
            }
        }
        inplaceCountingSort(vowels, true)
        val result = StringBuilder()
        for (c in s) {
            if (lookup.containsKey(c)) {
                result.append(VOWELS[vowels.removeAt(vowels.lastIndex)])
            } else {
                result.append(c)
            }
        }
        return result.toString()
    }

    companion object {
        private const val VOWELS = "AEIOUaeiou"
    }
}
