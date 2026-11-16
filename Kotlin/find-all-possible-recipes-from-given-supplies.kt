package findallpossiblerecipesfromgivensupplies

// Time:  O(|E|)
// Space: O(|E|)

class Solution {
    fun findAllRecipes(
        recipes: List<String>,
        ingredients: List<List<String>>,
        supplies: List<String>
    ): List<String> {
        val indegree = HashMap<String, Int>()
        val adj = HashMap<String, MutableList<String>>()
        for (i in recipes.indices) {
            indegree[recipes[i]] = ingredients[i].size
            for (ingredient in ingredients[i]) {
                adj.getOrPut(ingredient) { ArrayList() }.add(recipes[i])
            }
        }
        val result = ArrayList<String>()
        val recipeSet = recipes.toHashSet()
        var queue = ArrayList(supplies)
        while (queue.isNotEmpty()) {
            val newQueue = ArrayList<String>()
            for (u in queue) {
                if (u in recipeSet) {
                    result.add(u)
                }
                for (v in adj[u].orEmpty()) {
                    val remaining = indegree.getValue(v) - 1
                    indegree[v] = remaining
                    if (remaining == 0) {
                        newQueue.add(v)
                    }
                }
            }
            queue = newQueue
        }
        return result
    }
}
