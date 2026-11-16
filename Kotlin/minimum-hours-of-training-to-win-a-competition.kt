package minimumhoursoftrainingtowinacompetition

// Time:  O(n)
// Space: O(1)

// greedy
class Solution {
    fun minNumberOfHours(initialEnergy: Int, initialExperience: Int, energy: IntArray, experience: IntArray): Int {
        var curEnergy = initialEnergy
        var curExperience = initialExperience
        var result = 0
        for (i in energy.indices) {
            val inc1 = maxOf((energy[i] + 1) - curEnergy, 0)
            val inc2 = maxOf((experience[i] + 1) - curExperience, 0)
            result += inc1 + inc2
            curEnergy += inc1 - energy[i]
            curExperience += inc2 + experience[i]
        }
        return result
    }
}
