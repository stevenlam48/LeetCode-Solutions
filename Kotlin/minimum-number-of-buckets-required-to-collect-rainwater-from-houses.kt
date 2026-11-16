package minimumnumberofbucketsrequiredtocollectrainwaterfromhouses
// Time:  O(n)
// Space: O(1)

class Solution {
    fun minimumBuckets(street: String): Int {
        val chars = street.toCharArray()
        var result = 0
        for (i in chars.indices) {
            if (chars[i] != 'H' || (i > 0 && chars[i - 1] == 'B')) {
                continue
            }
            if (i + 1 < chars.size && chars[i + 1] == '.') {
                chars[i + 1] = 'B'
                ++result
            } else if (i > 0 && chars[i - 1] == '.') {
                chars[i - 1] = 'B'
                ++result
            } else {
                return -1
            }
        }
        return result
    }
}
