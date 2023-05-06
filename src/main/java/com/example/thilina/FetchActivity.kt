package com.example.thilina

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.thilina.adapter.EmpAdapter
import com.example.thilina.models.EmployeeModel
import com.google.firebase.database.*

class FetchActivity : AppCompatActivity() {

    private lateinit var empRecyclerView: RecyclerView
    private lateinit var tvLoadingData : TextView
    private lateinit var empList:ArrayList<EmployeeModel>
    private lateinit var dbRef : DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fetch)


        empRecyclerView = findViewById(R.id.rvInfo)
        empRecyclerView.layoutManager = LinearLayoutManager(this)
        empRecyclerView.setHasFixedSize(true)
        tvLoadingData =findViewById(R.id.tvLoadingData)


        empList = arrayListOf<EmployeeModel>()

        getEmployeesData()
    }
    private fun getEmployeesData(){
        empRecyclerView.visibility = View.GONE
        tvLoadingData.visibility = View.VISIBLE

        dbRef = FirebaseDatabase.getInstance().getReference("Thilina")

        dbRef.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                empList.clear()
                if(snapshot.exists()){
                    for(empSnap in snapshot.children){
                        val empData = empSnap.getValue(EmployeeModel::class.java)
                        empList.add(empData!!)
                    }
                    val mAdapter = EmpAdapter(empList)
                    empRecyclerView.adapter = mAdapter

                    //Click Employee Name and get His or her Info

                    mAdapter.setOnItemClickListener(object: EmpAdapter.onItemClickListener{
                        override fun onItemClick(position: Int) {
                            val intent= Intent(this@FetchActivity, Booking::class.java)


                            //put extras
                            intent.putExtra("empId", empList[position].empId)
                            intent.putExtra("empName", empList[position].empName)
                            intent.putExtra("empEmail", empList[position].empEmail)
                            intent.putExtra("empPhone", empList[position].empPhone)
                            intent.putExtra("empRes", empList[position].empRes)
                            intent.putExtra("empReg", empList[position].empReg)
                            intent.putExtra("empHotel", empList[position].empHotel)
                            intent.putExtra("empComEmail", empList[position].empComEmail)
                            intent.putExtra("empFloor", empList[position].empFloor)
                            intent.putExtra("empDes", empList[position].empDes)


                            startActivity(intent)


                        }

                    })

                    empRecyclerView.visibility = View.VISIBLE
                    tvLoadingData.visibility = View.GONE

                }


            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


    }
}