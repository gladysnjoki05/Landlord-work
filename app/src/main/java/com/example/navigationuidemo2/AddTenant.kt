package com.example.navigationuidemo2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.navigationuidemo2.databinding.AddtenantActivityBinding

class AddTenant : AppCompatActivity() {
    private lateinit var binding: AddtenantActivityBinding
    private val viewModel: TenantViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LIFECYCLE", "AddTenantActivity - onCreate")

        binding = DataBindingUtil.setContentView(this, R.layout.addtenant_activity)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.button.setOnClickListener {
            val name = binding.fullName.text.toString()
            val unit = binding.unitNumber.text.toString()
            val rent = binding.fullRent.text.toString()

            if (name.isNotBlank() && unit.isNotBlank() && rent.isNotBlank()) {
                viewModel.addTenant(name, unit, rent)
                binding.fullName.text?.clear()
                binding.unitNumber.text?.clear()
                binding.fullRent.text?.clear()
            }
        }

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d("LIFECYCLE", "SecondActivity - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LIFECYCLE", "SecondActivity - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LIFECYCLE", "SecondActivity - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LIFECYCLE", "SecondActivity - onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("LIFECYCLE", "SecondActivity - onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LIFECYCLE", "SecondActivity - onDestroy")
    }
}