package com.example.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val addbtn:Button=findViewById(R.id.Add)
        val removebtn:Button=findViewById(R.id.Remove)
        var Total:Int=0
        val result:TextView=findViewById(R.id.Result)
        var flag: String = "-"
        val spinnerVal: Spinner = findViewById(R.id.Menu)
        var options = arrayOf("Classic Burger  6$", "Pizza  7$","CheeseBurger  4$")
        spinnerVal.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)

        spinnerVal.onItemSelectedListener= object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
            addbtn.setOnClickListener{
            Total+=Addition(flag)
                result.text=Total.toString()

            }

        removebtn.setOnClickListener{
        Total -=Subtract(flag,Total)
            result.text=Total.toString()

        }

    }

    public fun Addition(Item:String):Int{
    if(Item=="Classic Burger  6$")
        return 6
        else if(Item=="Pizza  7$")
            return 7
        else if(Item=="CheeseBurger  4$")
            return 4
        else
            return 0
    }
    public fun Subtract(Item:String,Total:Int):Int{
        if(Item=="Classic Burger  6$" && Total>=6)
            return 6
        else if(Item=="Pizza  7$" && Total>=7)
            return 7
        else if(Item=="CheeseBurger  4$" && Total>=4)
            return 4
        else
            return 0
}}

