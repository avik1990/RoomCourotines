package com.app.roomcourotines.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.roomcourotines.model.Address
import com.app.roomcourotines.model.Department
import com.app.roomcourotines.model.Employee
import com.app.roomcourotines.model.Salary

@Database(
    entities = [Employee::class, Department::class, Address::class, Salary::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun employeeDao(): EmployeeDao
    abstract fun addressDao(): AddressDao
    abstract fun deptDao(): DepartmentDao
    abstract fun salaryDao(): SalaryDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java, "employee.db"
                    )
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}
