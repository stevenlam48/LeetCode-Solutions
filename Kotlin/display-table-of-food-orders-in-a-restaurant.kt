package displaytableoffoodordersinarestaurant

import java.util.TreeMap
import java.util.TreeSet

// Time:  O(n + tlogt + flogf)
// Space: O(n)

class Solution {
    fun displayTable(orders: List<List<String>>): List<List<String>> {
        val tableCount = TreeMap<Int, HashMap<String, Int>>()
        val foods = TreeSet<String>()
        for (order in orders) {
            val table = order[1].toInt()
            val food = order[2]
            tableCount.getOrPut(table) { HashMap() }.merge(food, 1, Int::plus)
            foods.add(food)
        }
        val result = mutableListOf<MutableList<String>>()
        result.add(mutableListOf("Table"))
        result.last().addAll(foods)
        for ((table, counts) in tableCount) {
            val row = mutableListOf(table.toString())
            for (food in foods) {
                row.add((counts[food] ?: 0).toString())
            }
            result.add(row)
        }
        return result
    }
}
