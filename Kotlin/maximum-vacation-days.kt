package maximumvacationdays

// Time:  O(n^2 * k)
// Space: O(k)

class Solution {
    fun maxVacationDays(flights: Array<IntArray>, days: Array<IntArray>): Int {
        if (days.isEmpty() || flights.isEmpty()) {
            return 0
        }
        val dp = Array(2) { IntArray(days.size) }
        for (week in days[0].size - 1 downTo 0) {
            for (currentCity in days.indices) {
                dp[week % 2][currentCity] = days[currentCity][week] + dp[(week + 1) % 2][currentCity]
                for (destinationCity in days.indices) {
                    if (flights[currentCity][destinationCity] == 1) {
                        dp[week % 2][currentCity] = maxOf(
                            dp[week % 2][currentCity],
                            days[destinationCity][week] + dp[(week + 1) % 2][destinationCity]
                        )
                    }
                }
            }
        }
        return dp[0][0]
    }
}
