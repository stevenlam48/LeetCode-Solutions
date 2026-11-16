package boatstosavepeople

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()
        var result = 0
        var left = 0
        var right = people.size - 1
        while (left <= right) {
            ++result
            if (people[left] + people[right] <= limit) {
                ++left
            }
            --right
        }
        return result
    }
}
