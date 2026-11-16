package designauctionsystem

import java.util.PriorityQueue

// Time:  ctor:             O(1)
//        addBid:           O(logn)
//        updateBid:        O(logn)
//        removeBid:        O(logn)
//        getHighestBidder: O(1), amortized
// Space: O(n)

class AuctionSystem {
    private val bids = HashMap<Int, HashMap<Int, Int>>()
    private val bidders = HashMap<Int, PriorityQueue<Pair<Int, Int>>>()

    fun addBid(userId: Int, itemId: Int, bidAmount: Int) {
        bids.getOrPut(itemId) { HashMap() }[userId] = bidAmount
        bidders.getOrPut(itemId) {
            PriorityQueue(compareByDescending<Pair<Int, Int>> { it.first }.thenByDescending { it.second })
        }.add(Pair(bidAmount, userId))
    }

    fun updateBid(userId: Int, itemId: Int, newAmount: Int) {
        addBid(userId, itemId, newAmount)
    }

    fun removeBid(userId: Int, itemId: Int) {
        val itemBids = bids[itemId] ?: return
        itemBids.remove(userId)
        if (itemBids.isEmpty()) {
            bids.remove(itemId)
        }
    }

    fun getHighestBidder(itemId: Int): Int {
        val heap = bidders[itemId] ?: return -1
        while (heap.isNotEmpty()) {
            val (p, u) = heap.peek()
            if ((bids[itemId]?.get(u) ?: 0) == p) {
                return u
            }
            heap.poll()
        }
        bidders.remove(itemId)
        return -1
    }
}
