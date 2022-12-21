package com.hanbitkang.core.data

/**
 * Interface for a class that is synchronized with remote.
 */
interface Syncable {
    /**
     * A function that synchronizes database over network.
     */
    suspend fun sync()
}