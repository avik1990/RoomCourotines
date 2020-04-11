package com.app.roomcourotines.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import com.app.roomcourotines.model.Address
import com.app.roomcourotines.model.Department
import com.app.roomcourotines.model.Employee
import com.app.roomcourotines.model.Salary

@Dao
interface SalaryDao {

    @Insert(onConflict = REPLACE)
    suspend fun insertSalaryDetails(sal: Salary): Long
/*
    @Insert(onConflict = REPLACE)
    suspend fun insertAddress(address: Address) :Unit

    @Insert(onConflict = REPLACE)
    suspend fun insertSalary(salary: Salary) :Unit

    @Insert(onConflict = REPLACE)
    suspend fun insertDepartment(dept: Department) :Unit*/
}