package waterbottlesii

// Time:  O(sqrt(n))
// Space: O(1)

// simulation
class Solution {
    fun maxBottlesDrunk(numBottles: Int, numExchange: Int): Int {
        var numBottles = numBottles
        var numExchange = numExchange
        var result = numBottles
        while (numBottles >= numExchange) {
            numBottles -= numExchange++
            ++result
            ++numBottles
        }
        return result
    }
}
