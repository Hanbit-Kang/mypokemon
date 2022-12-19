package com.hanbitkang.core.data

/**
 * An interface for a class that is synchronized with remote.
 */
interface Syncable {
    suspend fun synchronize()
}