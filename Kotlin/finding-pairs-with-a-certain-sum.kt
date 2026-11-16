package findingpairswithacertainsum

// Time:  ctor:  O(n1 + n2)
//        add:   O(1)
//        count: O(n1)
// Space: O(n1 + n2)

class FindSumPairs(nums1: IntArray, nums2: IntArray) {
    private val nums2 = nums2.copyOf()
    private val count1 = HashMap<Int, Int>()
    private val count2 = HashMap<Int, Int>()

    init {
        for (x in nums1) {
            count1[x] = (count1[x] ?: 0) + 1
        }
        for (x in nums2) {
            count2[x] = (count2[x] ?: 0) + 1
        }
    }

    fun add(index: Int, value: Int) {
        val oldValue = nums2[index]
        count2[oldValue] = count2.getValue(oldValue) - 1
        nums2[index] += value
        val newValue = nums2[index]
        count2[newValue] = (count2[newValue] ?: 0) + 1
    }

    fun count(tot: Int): Int {
        var result = 0
        for ((x, cnt) in count1) {
            if (count2.containsKey(tot - x)) {
                result += cnt * count2.getValue(tot - x)
            }
        }
        return result
    }
}
