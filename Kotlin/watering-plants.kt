package wateringplants

// Time:  O(n)
// Space: O(1)

class Solution {
    fun wateringPlants(plants: IntArray, capacity: Int): Int {
        var result = plants.size
        var can = capacity
        for (i in plants.indices) {
            if (can < plants[i]) {
                result += 2 * i
                can = capacity
            }
            can -= plants[i]
        }
        return result
    }
}
