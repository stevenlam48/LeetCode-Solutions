package maximumunitsonatruck

// Time:  O(nlogn)
// Space: O(1)

class Solution {
    fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {
        boxTypes.sortByDescending { it[1] }
        var remaining = truckSize
        var result = 0
        for (boxType in boxTypes) {
            if (remaining > boxType[0]) {
                remaining -= boxType[0]
                result += boxType[0] * boxType[1]
            } else {
                result += remaining * boxType[1]
                break
            }
        }
        return result
    }
}
