package maximummatchingofplayerswithtrainers

// Time:  O(nlogn + mlogm)
// Space: O(1)

class Solution {
    fun matchPlayersAndTrainers(players: IntArray, trainers: IntArray): Int {
        players.sort()
        trainers.sort()
        var result = 0
        for (trainer in trainers) {
            if (result == players.size) {
                break
            }
            if (trainer < players[result]) {
                continue
            }
            result++
        }
        return result
    }
}
