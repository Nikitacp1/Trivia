package com.task.trivia

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class NameFragment : Fragment() {

    lateinit var etName : EditText
    lateinit var btNext : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_capture_name, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        etName = view.findViewById(R.id.etName)
        btNext = view.findViewById(R.id.btNext)

        // perform setOnClickListener event on Second Button
        btNext.setOnClickListener(View.OnClickListener { // load Second Fragment
            if (!etName.text.toString().equals(null) && etName.text.toString() != "") {

                val bundle = Bundle()
                bundle.putString("name", etName.text.toString())
                val crickterFragment = CrickterFragment()
                crickterFragment.arguments = bundle

                val fm: FragmentManager = activity?.supportFragmentManager!!
                val fragmentTransaction = fm.beginTransaction()
                fragmentTransaction.add(R.id.frame_container, crickterFragment).isAddToBackStackAllowed
                fragmentTransaction.commit() // save the changes


            } else {
                Toast.makeText(context, "Please enter name to proceed", Toast.LENGTH_LONG)
            }


        })

    }
}