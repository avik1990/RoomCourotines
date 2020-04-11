package com.app.roomcourotines.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_employee")
data class Employee(
    @PrimaryKey(autoGenerate = true)
    var empId: Long? = null,
    @ColumnInfo(name = "empName")
    var empName: String? = null,
    @ColumnInfo(name = "phoneNo")
    var phoneNo: String? = null
)