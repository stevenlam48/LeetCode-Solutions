package minimumamountofdamagedealttobob

// Time:  O(nlogn)
// Space: O(n)

class Solution {
    fun minDamage(power: Int, damage: IntArray, health: IntArray): Long {
        for (i in health.indices) {
            health[i] = (health[i] + power - 1) / power
        }
        val indices = health.indices.sortedWith { a, b ->
            (health[a].toLong() * damage[b]).compareTo(health[b].toLong() * damage[a])
        }
        var result = 0L
        var time = 0L
        for (i in indices) {
            time += health[i]
            result += time * damage[i]
        }
        return result
    }
}
