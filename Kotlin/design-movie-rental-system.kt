package designmovierentalsystem

import java.util.TreeSet

// Time:  ctor:   O(nlogn)
//        search: O(logn)
//        rent:   O(logn)
//        drop:   O(logn)
//        report: O(logn)
// Space: O(n)

class MovieRentingSystem(n: Int, entries: Array<IntArray>) {
    private val movieToOrderedPriceShop = HashMap<Int, TreeSet<Pair<Int, Int>>>()
    private val shopMovieToPrice = HashMap<Int, HashMap<Int, Int>>()
    private val rentedOrderedPriceShopMovie = TreeSet<Triple<Int, Int, Int>>(
        compareBy<Triple<Int, Int, Int>>({ it.first }, { it.second }, { it.third })
    )

    init {
        for (e in entries) {
            movieToOrderedPriceShop.getOrPut(e[1]) {
                TreeSet(compareBy<Pair<Int, Int>>({ it.first }, { it.second }))
            }.add(Pair(e[2], e[0]))
            shopMovieToPrice.getOrPut(e[0]) { HashMap() }[e[1]] = e[2]
        }
    }

    fun search(movie: Int): IntArray {
        val result = ArrayList<Int>()
        for ((_, shop) in movieToOrderedPriceShop[movie] ?: emptySet<Pair<Int, Int>>()) {
            result.add(shop)
            if (result.size == 5) {
                break
            }
        }
        return result.toIntArray()
    }

    fun rent(shop: Int, movie: Int) {
        val price = shopMovieToPrice[shop]!![movie]!!
        movieToOrderedPriceShop[movie]!!.remove(Pair(price, shop))
        rentedOrderedPriceShopMovie.add(Triple(price, shop, movie))
    }

    fun drop(shop: Int, movie: Int) {
        val price = shopMovieToPrice[shop]!![movie]!!
        movieToOrderedPriceShop[movie]!!.add(Pair(price, shop))
        rentedOrderedPriceShopMovie.remove(Triple(price, shop, movie))
    }

    fun report(): Array<IntArray> {
        val result = ArrayList<IntArray>()
        for ((_, shop, movie) in rentedOrderedPriceShopMovie) {
            result.add(intArrayOf(shop, movie))
            if (result.size == 5) {
                break
            }
        }
        return result.toTypedArray()
    }
}
