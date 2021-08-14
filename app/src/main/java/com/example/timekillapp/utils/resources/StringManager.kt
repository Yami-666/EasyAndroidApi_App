package com.example.timekillapp.utils.resources

import android.content.Context
import com.example.timekillapp.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class StringManager @Inject constructor (
    @ApplicationContext val context: Context
): IStringManager {
    override fun getExampleString(hello: String): String {
        return context.getString(R.string.example, hello)
    }
}

interface IStringManager {
    fun getExampleString(hello: String): String
}