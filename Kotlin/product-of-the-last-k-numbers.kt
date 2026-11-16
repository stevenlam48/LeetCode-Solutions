package productofthelastknumbers

// Time:  ctor: O(1)
//        add : O(1)
//        get : O(1)
// Space: O(n)

class ProductOfNumbers {
    private var accu = mutableListOf(1)

    fun add(num: Int) {
        if (num == 0) {
            accu = mutableListOf(1)
            return
        }
        accu.add(accu.last() * num)
    }

    fun getProduct(k: Int): Int {
        if (accu.size <= k) {
            return 0
        }
        return accu.last() / accu[accu.size - 1 - k]
    }
}
