package designafoodratingsystem

import java.util.TreeSet

// Time:  ctor:         O(nlogn)
//        changeRating: O(logn)
//        highestRated: O(1)
// Space: O(n)

class FoodRatings(foods: Array<String>, cuisines: Array<String>, ratings: IntArray) {
    private val foodToCuisine = HashMap<String, String>()
    private val foodToRating = HashMap<String, Int>()
    private val cuisineToRatingFoods = HashMap<String, TreeSet<Pair<Int, String>>>()

    init {
        for (i in ratings.indices) {
            foodToCuisine[foods[i]] = cuisines[i]
            foodToRating[foods[i]] = ratings[i]
            cuisineToRatingFoods.getOrPut(cuisines[i]) {
                TreeSet(compareBy<Pair<Int, String>>({ it.first }, { it.second }))
            }.add(Pair(-ratings[i], foods[i]))
        }
    }

    fun changeRating(food: String, newRating: Int) {
        val oldRating = foodToRating[food]!!
        val cuisine = foodToCuisine[food]!!
        cuisineToRatingFoods[cuisine]!!.remove(Pair(-oldRating, food))
        foodToRating[food] = newRating
        cuisineToRatingFoods[cuisine]!!.add(Pair(-newRating, food))
    }

    fun highestRated(cuisine: String): String {
        return cuisineToRatingFoods[cuisine]!!.first().second
    }
}
