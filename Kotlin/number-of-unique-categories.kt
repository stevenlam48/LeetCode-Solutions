package numberofuniquecategories

// Time:  O(n^2)
// Space: O(1)

interface CategoryHandler {
    fun haveSameCategory(a: Int, b: Int): Boolean
}

class Solution {
    fun numberOfCategories(n: Int, categoryHandler: CategoryHandler): Int {
        var cnt = 0
        for (i in 0 until n) {
            for (j in 0 until i) {
                if (categoryHandler.haveSameCategory(j, i)) {
                    ++cnt
                    break
                }
            }
        }
        return n - cnt
    }
}
