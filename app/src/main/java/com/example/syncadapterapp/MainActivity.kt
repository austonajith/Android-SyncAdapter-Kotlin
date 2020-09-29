package com.example.syncadapterapp

import android.accounts.Account
import android.accounts.AccountManager
import android.content.*
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


const val AUTHORITY = "com.example.syncadapterapp.sync.StubProvider"
// Account type
const val ACCOUNT_TYPE = "com.syncadapterapp"
// Account
const val ACCOUNT = "default_account"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mAccount = CreateSyncAccount(this)
        val settings =  Bundle()
        settings.putBoolean(ContentResolver.SYNC_EXTRAS_MANUAL, true)
        settings.putBoolean(ContentResolver.SYNC_EXTRAS_EXPEDITED, true)

        ContentResolver.setSyncAutomatically(mAccount, AUTHORITY, true);
        ContentResolver.setIsSyncable(mAccount, AUTHORITY, 1)

        ContentResolver.requestSync(mAccount, AUTHORITY,settings)

        Log.d("udinic",ContentResolver.isSyncActive(mAccount, AUTHORITY).toString())
        Log.d("udinic",ContentResolver.isSyncPending(mAccount, AUTHORITY).toString())
        Log.d("udinic",ContentResolver.getIsSyncable(mAccount, AUTHORITY).toString())

    }

    fun CreateSyncAccount(context: Context): Account? {
        // Create the account type and default account
        val newAccount = Account(ACCOUNT, ACCOUNT_TYPE)
        // Get an instance of the Android account manager
        val accountManager =
            context.getSystemService(Context.ACCOUNT_SERVICE) as AccountManager
        /*
         * Add the account and account type, no password or user data
         * If successful, return the Account object, otherwise report an error.
         */if (accountManager.addAccountExplicitly(newAccount, null, null)) {
            /*
             * If you don't set android:syncable="true" in
             * in your <provider> element in the manifest,
             * then call context.setIsSyncable(account, AUTHORITY, 1)
             * here.
             */
        } else {
            /*
             * The account exists or some other error occurred. Log this, report it,
             * or handle it internally.
             */
        }
        return newAccount
    }
}