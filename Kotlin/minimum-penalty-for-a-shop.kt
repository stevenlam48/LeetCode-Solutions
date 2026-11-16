package minimumpenaltyforashop
// Time:  O(n)
// Space: O(1)

class Solution {
    fun bestClosingTime(customers: String): Int {
        var result = 0
        var mx = 0
        var curr = 0
        for (i in customers.indices) {
            curr += if (customers[i] == 'Y') 1 else -1
            if (curr > mx) {
                mx = curr
                result = i + 1
            }
        }
        return result
    }
}
