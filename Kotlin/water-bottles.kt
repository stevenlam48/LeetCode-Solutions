package waterbottles

// Time:  O(logn/logm), n is numBottles, m is numExchange
// Space: O(1)

class Solution {
    fun numWaterBottles(numBottles: Int, numExchange: Int): Int {
        var numBottles = numBottles
        var result = numBottles
        while (numBottles >= numExchange) {
            result += numBottles / numExchange
            numBottles = numBottles / numExchange + numBottles % numExchange
        }
        return result
    }
}
