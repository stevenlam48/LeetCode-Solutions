package maximumsplitofpositiveevenintegers

// Time:  O(sqrt(n))
// Space: O(1)

class Solution {
    fun maximumEvenSplit(finalSum: Long): List<Long> {
        if (finalSum % 2 != 0L || finalSum == 0L) {
            return emptyList()
        }
        val result = ArrayList<Long>()
        var sum = finalSum
        var i = 2L
        while (i <= sum) {
            result.add(i)
            sum -= i
            i += 2
        }
        result[result.size - 1] += sum
        return result
    }
}
