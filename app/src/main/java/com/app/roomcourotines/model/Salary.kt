package com.app.roomcourotines.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_salary")
data class Salary(
    @PrimaryKey(autoGenerate = true)
    var sal_id: Long? = null,
    @ColumnInfo(name="empId")
    var empId: Long?=null,
    @ColumnInfo(name="salary")
    var salary: Double?=null
)