package designordermanagementsystem

// Time:  ctor:             O(1)
//        addOrder:         O(1)
//        modifyOrder:      O(1)
//        cancelOrder:      O(1)
//        getOrdersAtPrice: O(n)
// Space: O(n)

class OrderManagementSystem {
    private class Order(var type: String, val price: Int, var index: Int)

    private val orders = HashMap<Int, Order>()
    private val typePrice = HashMap<String, HashMap<Int, MutableList<Int>>>()

    fun addOrder(orderId: Int, orderType: String, price: Int) {
        val arr = typePrice.getOrPut(orderType) { HashMap() }.getOrPut(price) { ArrayList() }
        orders[orderId] = Order(orderType, price, arr.size)
        arr.add(orderId)
    }

    fun modifyOrder(orderId: Int, newPrice: Int) {
        val orderType = orders[orderId]!!.type
        cancelOrder(orderId)
        addOrder(orderId, orderType, newPrice)
    }

    fun cancelOrder(orderId: Int) {
        val order = orders[orderId]!!
        val arr = typePrice[order.type]!![order.price]!!
        orders[arr.last()]!!.index = order.index
        arr[order.index] = arr.last()
        arr.removeAt(arr.size - 1)
        if (arr.isEmpty()) {
            val prices = typePrice[order.type]!!
            prices.remove(order.price)
            if (prices.isEmpty()) {
                typePrice.remove(order.type)
            }
        }
        orders.remove(orderId)
    }

    fun getOrdersAtPrice(orderType: String, price: Int): IntArray {
        val prices = typePrice[orderType]
        val arr = prices?.get(price)
        return arr?.toIntArray() ?: IntArray(0)
    }
}
