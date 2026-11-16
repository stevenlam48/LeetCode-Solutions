package maximumpopulationyear
// Time:  O(n)
// Space: O(1)

class Solution {
    fun maximumPopulation(logs: Array<IntArray>): Int {
        val minimumYear = 1950
        val maximumYear = 2050
        val years = IntArray(maximumYear - minimumYear + 1)
        for (log in logs) {
            ++years[log[0] - minimumYear]
            --years[log[1] - minimumYear]
        }
        var result = 0
        for (i in years.indices) {
            if (i != 0) {
                years[i] += years[i - 1]
            }
            if (years[i] > years[result]) {
                result = i
            }
        }
        return result + minimumYear
    }
}
