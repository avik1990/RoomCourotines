package com.app.roomcourotines

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.app.roomcourotines.db.AppDatabase
import com.app.roomcourotines.model.Address
import com.app.roomcourotines.model.Department
import com.app.roomcourotines.model.Employee
import com.app.roomcourotines.model.Salary
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    lateinit var context: Context
    lateinit var appDatabase: AppDatabase
    lateinit var emp: Employee
    lateinit var address: Address
    lateinit var department: Department
    lateinit var salary: Salary

    var empId: Long = 0
    var salaryId: Long = 0

    protected lateinit var job: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        context = this
        job = Job()

        btnSave.setOnClickListener(View.OnClickListener {
            verifyFormData()
        })
    }

    private fun verifyFormData() {
        if (empName.text.isEmpty()) {
            return
        }
        if (empPhoneno.text.isEmpty()) {
            return
        }
        if (empFlatno.text.isEmpty()) {
            return
        }
        if (empStreetName.text.isEmpty()) {
            return
        }
        if (empLandmark.text.isEmpty()) {
            return
        }
        if (empDeptName.text.isEmpty()) {
            return
        }
        if (empSalary.text.isEmpty()) {
            return
        }

        launch(Dispatchers.Main) {
            appDatabase = AppDatabase.getInstance(context)
            //insert Employee 
            emp= Employee()
            emp.empName== empName.text.toString().trim()
            emp.phoneNo== empPhoneno.text.toString().trim()
            empId = appDatabase.employeeDao().insertContactDetails(emp)

            //insert Address
            address = Address()
            address.empId = empId
            address.streetName = empStreetName.text.toString().trim()
            address.landmark = empLandmark.text.toString().trim()
            appDatabase.addressDao().insertAddressDetails(address)

            //insert Department
            department = Department()
            department.empId = empId
            department.deptName = empDeptName.text.toString().trim()
            appDatabase.deptDao().insertDeptDetails(department)

            //insert Salary
            salary = Salary()
            salary.empId = empId
            salary.salary = empSalary.text.toString().trim().toDouble()
            salaryId = appDatabase.salaryDao().insertSalaryDetails(salary)

            Toast.makeText(context, "SalaryID: " + salaryId, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

}
