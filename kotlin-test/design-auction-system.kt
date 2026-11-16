package designauctionsystem

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DesignAuctionSystemTest {
    @Test
    fun testBasicFlow() {
        val auction = AuctionSystem()
        auction.addBid(1, 1, 10)
        auction.addBid(2, 1, 20)
        auction.addBid(3, 1, 15)
        assertEquals(2, auction.getHighestBidder(1))
        auction.updateBid(1, 1, 25)
        assertEquals(1, auction.getHighestBidder(1))
        auction.removeBid(2, 1)
        assertEquals(1, auction.getHighestBidder(1))
        assertEquals(-1, auction.getHighestBidder(2))
    }

    @Test
    fun testTieBreaksByHigherUserId() {
        val auction = AuctionSystem()
        auction.addBid(1, 1, 10)
        auction.addBid(2, 1, 10)
        assertEquals(2, auction.getHighestBidder(1))
    }

    @Test
    fun testRemoveHighestFallsBack() {
        val auction = AuctionSystem()
        auction.addBid(1, 1, 10)
        auction.addBid(2, 1, 20)
        auction.removeBid(2, 1)
        assertEquals(1, auction.getHighestBidder(1))
    }

    @Test
    fun testRemoveAllBids() {
        val auction = AuctionSystem()
        auction.addBid(1, 1, 10)
        auction.removeBid(1, 1)
        assertEquals(-1, auction.getHighestBidder(1))
    }

    @Test
    fun testMultipleItems() {
        val auction = AuctionSystem()
        auction.addBid(1, 1, 10)
        auction.addBid(2, 2, 20)
        assertEquals(1, auction.getHighestBidder(1))
        assertEquals(2, auction.getHighestBidder(2))
    }
}
