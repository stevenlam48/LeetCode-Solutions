package numberofburgerswithnowasteofingredients
// Time:  O(1)
// Space: O(1)

class Solution {
    fun numOfBurgers(tomatoSlices: Int, cheeseSlices: Int): IntArray {
        if (tomatoSlices % 2 == 0 &&
            2 * cheeseSlices <= tomatoSlices &&
            tomatoSlices <= 4 * cheeseSlices
        ) {
            return intArrayOf(
                tomatoSlices / 2 - cheeseSlices,
                2 * cheeseSlices - tomatoSlices / 2
            )
        }
        return intArrayOf()
    }
}
