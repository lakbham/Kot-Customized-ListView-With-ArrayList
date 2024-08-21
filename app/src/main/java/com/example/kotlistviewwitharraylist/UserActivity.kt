package com.example.kotlistviewwitharraylist


import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.kotlistviewwitharraylist.databinding.ActivityUserBinding


class UserActivity : ComponentActivity(){
   private lateinit var binding : ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name")
        val phone = intent.getStringExtra("phone")
        val country = intent.getStringExtra("country")
        val imageId = intent.getIntExtra("imageId", R.drawable.a)

        binding.nameProfile.text = name
        binding.phoneProfile.text = phone
        binding.countryProfile.text = country
        binding.profileImage.setImageResource(imageId)

    }
}