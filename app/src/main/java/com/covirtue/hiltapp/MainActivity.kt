package com.covirtue.hiltapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    //field injection
    @Inject
    lateinit var someClass: SomeClass

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, someClass.doAThing(), Toast.LENGTH_LONG).show()
        Toast.makeText(this, someClass.doSomeOtherThingsTwo(), Toast.LENGTH_LONG).show()
    }
}

class SomeClass
@Inject
constructor(
    //constructor injection
    private val someOtherClass: SomeOtherClass
) {
    fun doAThing() : String {
        return "Hello World"
    }

    fun doSomeOtherThingsTwo() : String {
        return someOtherClass.doSomeOtherThing()
    }
}


class SomeOtherClass
@Inject
constructor() {
    fun doSomeOtherThing() : String {
        return "Hello World Two"
    }
}