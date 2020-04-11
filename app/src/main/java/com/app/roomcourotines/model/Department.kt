package com.app.roomcourotines.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_dept")
data class Department(
    @PrimaryKey(autoGenerate = true)
    var dept_id: Long? = null,
    @ColumnInfo(name = "empId")
    var empId: Long?=null,
    @ColumnInfo(name = "deptName")
    var deptName: String?=null
)