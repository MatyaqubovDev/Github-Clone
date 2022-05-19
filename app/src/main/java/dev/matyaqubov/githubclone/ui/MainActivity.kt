package dev.matyaqubov.githubclone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.matyaqubov.githubclone.R
import dev.matyaqubov.githubclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}