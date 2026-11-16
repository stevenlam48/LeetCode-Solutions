package convertthetemperature

// Time:  O(1)
// Space: O(1)

class Solution {
    fun convertTemperature(celsius: Double): DoubleArray {
        return doubleArrayOf(celsius + 273.15, celsius * 1.80 + 32.00)
    }
}
