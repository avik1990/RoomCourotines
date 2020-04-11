package com.app.roomcourotines.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_address")
data class Address(
    @PrimaryKey(autoGenerate = true)
    var address_id: Long? = null,
    @Ignore
    @ColumnInfo(name = "empId")
    var empId: Long? = null,
    @ColumnInfo(name = "flatNo")
    var flatNo: String? = null,
    @ColumnInfo(name = "streetName")
    var streetName: String? = null,
    @ColumnInfo(name = "landmark")
    var landmark: String? = null
)