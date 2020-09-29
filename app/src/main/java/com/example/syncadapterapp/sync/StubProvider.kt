package com.example.syncadapterapp.sync

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri

/*
 * Define an implementation of ContentProvider that stubs out
 * all methods
 */
class StubProvider : ContentProvider() {
    override fun insert(uri: Uri, values: ContentValues?): Uri? = null

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? = null


    /*
     * Always return true, indicating that the
     * provider loaded correctly.
     */
    override fun onCreate(): Boolean = true
    override fun update(
        uri: Uri,
        values: ContentValues?,
        selection: String?,
        selectionArgs: Array<out String>?
    ): Int {
        return 0
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        TODO("Not yet implemented")
    }

    /*
     * Return no type for MIME type
     */
    override fun getType(uri: Uri): String? = null

}