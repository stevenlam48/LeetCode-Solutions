package faultysensor

// Time:  O(n)
// Space: O(1)

class Solution {
    fun badSensor(sensor1: IntArray, sensor2: IntArray): Int {
        var i = 0
        while (i + 1 < sensor1.size) {
            if (sensor1[i] == sensor2[i]) {
                ++i
                continue
            }
            while (i + 1 < sensor2.size && sensor2[i + 1] == sensor1[i]) {
                ++i
            }
            return if (i + 1 == sensor2.size) 1 else 2
        }
        return -1
    }
}
