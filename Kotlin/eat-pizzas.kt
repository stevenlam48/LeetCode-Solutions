package eatpizzas

// Time:  O(nlogn)
// Space: O(1)
class Solution {
    fun maxWeight(pizzas: IntArray): Long {
        val l = pizzas.size / 4
        pizzas.sortDescending()
        var result = 0L
        for (i in 0 until (l + 1) / 2) {
            result += pizzas[i]
        }
        var i = (l + 1) / 2 + 1
        while (i < (l + 1) / 2 + (l / 2) * 2) {
            result += pizzas[i]
            i += 2
        }
        return result
    }
}
