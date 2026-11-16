package phonenumberprefix
// Time:  O(l * nlogn)
// Space: O(1)

class Solution {
    fun phonePrefix(numbers: Array<String>): Boolean {
        numbers.sort()
        for (i in 0 until numbers.size - 1) {
            if (numbers[i + 1].startsWith(numbers[i])) {
                return false
            }
        }
        return true
    }
}
