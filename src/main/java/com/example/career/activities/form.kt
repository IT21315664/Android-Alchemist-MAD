package com.example.career.activities



import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.career.models.EmployeeModel
import com.example.career.R

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class form : AppCompatActivity() {

//Data Insert
    //Intialize Variables

    private lateinit var edtLname :EditText
    private lateinit var edtEmail :EditText
    private lateinit var edtAge    :EditText
    private lateinit var edtPhone  :EditText
    private lateinit var edtExperience:EditText
    private lateinit var edtSalary :EditText
    private lateinit var tvQual :EditText
    private lateinit var btnSaveData :Button

    private lateinit var dbRef : DatabaseReference



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        edtLname= findViewById(R.id.edtLname)
        edtEmail = findViewById(R.id.edtEmail)
        edtAge = findViewById(R.id.edtAge)
        edtPhone = findViewById(R.id.edtPhone)
        edtExperience = findViewById(R.id.edtExperience)
        edtSalary = findViewById(R.id.tvSalary)
        tvQual = findViewById(R.id.edtQual)
        btnSaveData =findViewById(R.id.btnSaveData)

        dbRef = FirebaseDatabase.getInstance().getReference( "Careers")

        btnSaveData.setOnClickListener{
            saveCareerData()
        }

    }
//Insert data to  Database
    private fun saveCareerData(){//Save Button
          //getting values

        val empLname = edtLname.text.toString()
        val empEmail = edtEmail.text.toString()
        val empAge = edtAge.text.toString()
        val empPhone =edtPhone.text.toString()
        val empExperience = edtExperience.text.toString()
        val empSalary = edtSalary.text.toString()
        val empQual = tvQual.text.toString()

//validation
    if(empLname.isEmpty()){
        edtLname.error ="Please enter the FullName"
    }
    if(empEmail.isEmpty()){
        edtEmail.error ="Please enter the Email"
    }
    if(empAge.isEmpty()){
        edtAge.error ="Please enter the Age"
    }
    if(empPhone.isEmpty()){
        edtPhone.error ="Please enter the PhoneNumber"
    }
    if(empExperience.isEmpty()){
        edtExperience.error ="Please enter the Experience"
    }
    if(empSalary.isEmpty()){
        edtSalary.error ="Please enter the Salary"
    }
    if(empQual.isEmpty()){
        tvQual.error ="Please enter the Qualifications"
    }


    val empId = dbRef.push().key!!

    val employee = EmployeeModel(empId,empLname,empEmail,empAge,empPhone,empExperience,empSalary,empQual)

    dbRef.child(empId).setValue(employee)
        .addOnCompleteListener {
            Toast.makeText(this, "Data Inserted Successfully",Toast.LENGTH_LONG).show()

            //After click save button all the info deleted in the fields
           edtLname.text.clear()
            edtEmail.text.clear()
            edtAge.text.clear()
            edtPhone.text.clear()
            edtExperience.text.clear()
            edtSalary.text.clear()
            tvQual.text.clear()




        }.addOnFailureListener {err->
            Toast.makeText(this, "Error ${err.message}",Toast.LENGTH_LONG).show()

        }


    }

}