package carfleet

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val cars = mutableListOf<Pair<Int, Double>>()
        for (i in position.indices) {
            cars.add(Pair(position[i], (target - position[i]).toDouble() / speed[i]))
        }
        cars.sortWith(compareBy({ it.first }, { it.second }))
        var result = 0
        var curr = 0.0
        for (i in position.size - 1 downTo 0) {
            if (cars[i].second > curr) {
                curr = cars[i].second
                ++result
            }
        }
        return result
    }
}
