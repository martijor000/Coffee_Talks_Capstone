package com.example.captone_coffee_talk


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.firestore.FirebaseFirestore


class UsersActivity : AppCompatActivity() {

    private lateinit var userRecyclerView: RecyclerView
    private lateinit var userList: ArrayList<User>
    private lateinit var adapter: UserAdapter

    //database reference
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        mAuth = FirebaseAuth.getInstance()
        mDbRef = FirebaseDatabase.getInstance().getReference("user")

        userList = ArrayList()
        adapter = UserAdapter(this, userList)

        userRecyclerView = findViewById(R.id.userRecyclerView)

        userRecyclerView.layoutManager = LinearLayoutManager(this)
        userRecyclerView.adapter = adapter

        mDbRef.child("user").addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                userList.clear()
                for(postSnapshot in snapshot.children){
                    val currentUser = postSnapshot.getValue(User::class.java)
                    if(mAuth.currentUser?.uid != currentUser?.id){
                        userList.add(currentUser!!)
                    }
                    userList.add(currentUser!!)
                }
                adapter.notifyDataSetChanged()
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })
    }
}