package com.example.upnews.db

import androidx.room.TypeConverter
import com.example.upnews.models.Source

class Converters {

    // Convert Source object to String (store name)
    @TypeConverter
    fun fromSource(source: Source?): String? {
        // Return the name, or null if source is null
        return source?.name
    }

    // Convert String back to Source object
    @TypeConverter
    fun toSource(name: String?): Source {
        // Handle null safely; default to empty string if name is null
        return Source(id = name ?: "", name = name ?: "")
    }
}
