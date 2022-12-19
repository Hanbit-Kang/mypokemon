package com.hanbitkang.core.data

/**
 * An interface for a class that synchronize data between local and remote.
 */
interface Synchronizer {

}

/**
 * An interface for a class that is synchronized with remote.
 */
interface Syncable {
    suspend fun syncWith(synchronizer: Synchronizer)
}