package com.josemiz.epamtest.test3

class UserProcessor {

    fun processUser(name:String, cardId:Int): UserLoginData {
        val primes = calculatePrimesInRange(1,1000)
        val randomPrime = primes.random()
        val uid = randomPrime * cardId
        return UserLoginData(name,uid.toString())
    }

    private fun isPrime(number: Int): Boolean {
        if (number <= 1) return false
        for (i in 2..<number) {
            if (number % i == 0) {
                return false
            }
        }
        return true
    }

    private fun calculatePrimesInRange(start: Int, end: Int): List<Int> {
        val primes = mutableListOf<Int>()

        for (number in start..end) {
            if (isPrime(number)) {
                primes.add(number)
            }
        }

        return primes
    }
}