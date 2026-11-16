package designridesharingsystem

// Time:  ctor:                 O(1)
//        addRider:             O(1)
//        addDriver:            O(1)
//        matchDriverWithRider: O(1)
//        cancelRider:          O(1)
// Space: O(n)

class RideSharingSystem {
    private val riders = LinkedHashSet<Int>()
    private val drivers = LinkedHashSet<Int>()

    fun addRider(riderId: Int) {
        riders.add(riderId)
    }

    fun addDriver(driverId: Int) {
        drivers.add(driverId)
    }

    fun matchDriverWithRider(): IntArray {
        if (riders.isEmpty() || drivers.isEmpty()) {
            return intArrayOf(-1, -1)
        }
        val r = riders.first()
        val d = drivers.first()
        riders.remove(r)
        drivers.remove(d)
        return intArrayOf(d, r)
    }

    fun cancelRider(riderId: Int) {
        riders.remove(riderId)
    }
}
