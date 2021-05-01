package com.task.trivia.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.task.trivia.R


class CrickterFragment : Fragment() {

    lateinit var btNext : Button
    lateinit var rgCricketerAction : RadioGroup
    lateinit var rbSachin : AppCompatRadioButton
    lateinit var rbVirat : AppCompatRadioButton
    lateinit var rbAdam : AppCompatRadioButton
    lateinit var rbJacques : AppCompatRadioButton

    var name : String = ""
    var cricketer : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_capture_cricketer, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btNext = view.findViewById(R.id.btNext)

        rgCricketerAction = view.findViewById(R.id.rgCricketerAction)
        rbSachin = view.findViewById(R.id.rbSachin)
        rbVirat = view.findViewById(R.id.rbVirat)
        rbAdam = view.findViewById(R.id.rbAdam)
        rbJacques = view.findViewById(R.id.rbJacques)

        val bundle = arguments
        name = bundle?.getString("name", "").toString()

        // perform setOnClickListener event on Second Button
        btNext.setOnClickListener(View.OnClickListener {

            if (rbSachin.isChecked || rbVirat.isChecked || rbAdam.isChecked || rbJacques.isChecked) {

                // get selected radio button from radioGroup
                val selectedId: Int = rgCricketerAction.checkedRadioButtonId
                var radioSelectedButton = view.findViewById(selectedId) as RadioButton

                val bundle = Bundle()
                bundle.putString("name", name)
                bundle.putString("cricketer", radioSelectedButton.text.toString())
                val colorFragment = ColorFragment()
                colorFragment.arguments = bundle

                val fm: FragmentManager = activity?.supportFragmentManager!!
                val fragmentTransaction = fm.beginTransaction()
                fragmentTransaction.add(R.id.frame_container, colorFragment)
                fragmentTransaction.commit() // save the changes
            } else {
                Toast.makeText(activity, "Please select cricketer to proceed", Toast.LENGTH_LONG)
            }

        });
    }
}