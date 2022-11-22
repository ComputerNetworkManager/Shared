package at.clanattack.xjkl.wait

import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class Lock {

    private var run = false
    private val lock = ReentrantLock()
    private val condition = lock.newCondition()

    val isFinished: Boolean
        get() = run

    fun await() {
        if (run) return

        lock.withLock {
            condition.await()
        }
    }

    fun signal() {
        run = true
        lock.withLock {
            condition.signalAll()
        }
    }

}