package com.dexin.gsonktdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.dexin.gsonktdemo.bean.Person
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var result: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
        initListener()
    }

    private fun initListener() {
        mMainBtn.setOnClickListener {
            initParse()
        }
    }

    private fun initParse() {
        val list = Gson().fromJson<List<Person>>(result, object : TypeToken<List<Person>>() {}.type)
        for (i in list) {
            Log.e("main", i.toString())
        }
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
