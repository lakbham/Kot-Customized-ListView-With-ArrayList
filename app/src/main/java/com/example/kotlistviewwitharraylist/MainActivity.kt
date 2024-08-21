package com.example.kotlistviewwitharraylist

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.kotlistviewwitharraylist.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var userArrayList : ArrayList<User>

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = intArrayOf(
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i
        )
        val name = arrayOf("chris", "Nolan", "Gargi", "penny", "Cruz","david", "Ginni", "Mohini", "Mrudul")
        val lastMessage = arrayOf("Hi", "Hi darling", "How r u?", "catchup", "Good Morning", "Good Night", "GoodEvening","lets chat", "May you are blessed")
        val  lastMessageTime = arrayOf("1:00 AM", "2:00 AM", "3:00 AM", "4:00 AM", "5:00 AM", "6:00 AM", "7:00 AM", "8:00 AM", "9:00 AM")
        val  phoneNo = arrayOf("1234567890", "2345678900", "3456789010", "4567890120", "5678901230", "6789012340", "7890123450", "8901234560", "9012345670")
        val country = arrayOf("paris", "India", "USA", "Brazil", "Aussie", "China", "Italy", "Spain", "Africa")

        userArrayList = ArrayList()

        for(i in name.indices){
            val user = User(name[i],lastMessage[i], lastMessageTime[i],phoneNo[i], country[i],imageId[i])
            userArrayList.add(user)
        }
     binding.listview.isClickable = true
      binding.listview.adapter = MyAdapter(this, userArrayList)
        binding.listview.setOnItemClickListener { parent, view, position, id ->
            val name: String = name[position]
            val phone: String = phoneNo[position]
            val country: String = country[position]
            val imageId = imageId[position]


            val ii = Intent(this,UserActivity::class.java)

            ii.putExtra("name", name)
            ii.putExtra("phone", phone)
            ii.putExtra("country", country)
            ii.putExtra("imageId", imageId)
            startActivity(ii)

        }

    }
}

