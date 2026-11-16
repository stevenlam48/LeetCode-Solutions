package alertusingsamekeycardthreeormoretimesinaonehourperiod

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun alertNames(keyName: List<String>, keyTime: List<String>): List<String> {
        val threshold = 3
        val nameToTimes = HashMap<String, MutableList<Int>>()
        for (i in keyName.indices) {
            val hour = keyTime[i].substring(0, 2).toInt()
            val minute = keyTime[i].substring(3).toInt()
            nameToTimes.getOrPut(keyName[i]) { mutableListOf() }.add(hour * 60 + minute)
        }
        val result = mutableListOf<String>()
        for ((name, times) in nameToTimes) {
            times.sort()
            var left = 0
            for (right in times.indices) {
                while (times[right] - times[left] > 60) {
                    ++left
                }
                if (right - left + 1 >= threshold) {
                    result.add(name)
                    break
                }
            }
        }
        result.sort()
        return result
    }
}
