package subdomainvisitcount

// Time:  O(n), is the length of cpdomains (assuming the length of cpdomains[i] is fixed)
// Space: O(n)

class Solution {
    fun subdomainVisits(cpdomains: List<String>): List<String> {
        val counts = HashMap<String, Int>()
        for (cpdomain in cpdomains) {
            val i = cpdomain.indexOf(" ")
            val count = cpdomain.substring(0, i).toInt()
            val domain = cpdomain.substring(i + 1)
            for (j in -1 until domain.length) {
                if (j != -1 && domain[j] != '.') {
                    continue
                }
                val key = domain.substring(j + 1)
                counts[key] = (counts[key] ?: 0) + count
            }
        }

        val result = mutableListOf<String>()
        for ((domain, count) in counts) {
            result.add("$count $domain")
        }
        return result
    }
}
