package majorityelementii

// Time:  O(n)
// Space: O(1)

class Solution {
    fun majorityElement(nums: IntArray): IntArray {
        val k = 3
        val n = nums.size
        val hash = HashMap<Int, Int>()

        for (i in nums) {
            hash[i] = (hash[i] ?: 0) + 1
            if (hash.size == k) {
                val iterator = hash.entries.iterator()
                while (iterator.hasNext()) {
                    val entry = iterator.next()
                    val count = entry.value - 1
                    if (count == 0) {
                        iterator.remove()
                    } else {
                        entry.setValue(count)
                    }
                }
            }
        }

        for (entry in hash) {
            entry.setValue(0)
        }

        for (i in nums) {
            if (hash.containsKey(i)) {
                hash[i] = hash.getValue(i) + 1
            }
        }

        val result = ArrayList<Int>()
        for (entry in hash) {
            if (entry.value > n / k) {
                result.add(entry.key)
            }
        }
        return result.toIntArray()
    }
}
