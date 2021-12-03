package com.example.spintask

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.spintask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var point: Int = 1000
    private var life: Int = 5
    private val spinResult = arrayOf("Bankrupt", "1000 Extra!", "Miss Turn", "Extra Turn!" )
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun replaceFragment(fragment: Fragment) {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment, fragment) //here
            fragmentTransaction.commit()
        }

        binding.restart.setOnClickListener {
            val intent: Intent = intent
            finish()
            startActivity(intent);
        }

        binding.playBtn.setOnClickListener {
            replaceFragment(Game())
        }
/*
        binding.button3.setOnClickListener {
            replaceFragment(GameRules())
        }
*/

    }


//_________________________________________________________________________________________________

    /*
             //  val toast = Toast.makeText(this,"Great spin!", Toast.LENGTH_SHORT)
            // toast.show()


     private fun spinAction(): String {
        val numbers = (0..1).random()
         println(spinResult[numbers])
        return spinResult[numbers]
    }

    fun life(): Int {
        if (spinAction() == spinResult[1]) {
            life -= 1
        }
        if (spinAction() == spinResult[2]) {
            life += 1
        }
        return life
    }

    private fun points(): Int {
        if (spinAction() == spinResult[0]) {
            point = 0
        }
        if (spinAction() == spinResult[1]) {
            point += 1000
        }
       println(point)
        return point
        */


    }





