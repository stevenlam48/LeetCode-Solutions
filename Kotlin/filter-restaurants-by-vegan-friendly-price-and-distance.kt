package filterrestaurantsbyveganfriendlypriceanddistance

// Time:  O(rlogr), r is the number of result
// Space: O(r)

class Solution {
    fun filterRestaurants(restaurants: Array<IntArray>, veganFriendly: Int, maxPrice: Int, maxDistance: Int): List<Int> {
        val result = mutableListOf<Int>()
        val lookup = HashMap<Int, Int>()
        for (i in restaurants.indices) {
            val r = restaurants[i]
            if (r[2] >= veganFriendly && r[3] <= maxPrice && r[4] <= maxDistance) {
                lookup[r[0]] = i
                result.add(r[0])
            }
        }
        result.sortWith(compareBy({ -restaurants[lookup[it]!!][1] }, { -restaurants[lookup[it]!!][0] }))
        return result
    }
}
