package com.dexin.gsonktdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    lateinit var result: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
    }

    private fun initData() {
        val ist = assets.open("data.json")
        val len = ist.available()
        val bytes = ByteArray(len)
        val read = ist.read(bytes)
        ist.close()
        result = String(bytes)
        Log.e("main", result)
    }
}
