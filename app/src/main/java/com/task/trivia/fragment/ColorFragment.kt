package com.task.trivia.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatCheckBox
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.task.trivia.*
import com.task.trivia.model.DetailsModel
import com.task.trivia.roomDatabase.DatabaseBuilder
import com.task.trivia.roomDatabase.DatabaseHelperImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.collections.ArrayList

internal class ColorFragment : Fragment() {

    lateinit var btNext : Button

    lateinit var cbWhite : AppCompatCheckBox
    lateinit var cbYellow : AppCompatCheckBox
    lateinit var cbOrange : AppCompatCheckBox
    lateinit var cbGreen : AppCompatCheckBox

    lateinit var name : String
    lateinit var cricketer : String
    private var colors : String = ""
    private var colorsList: ArrayList<String> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_capture_color, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btNext = view.findViewById(R.id.btNext)

        cbWhite = view.findViewById(R.id.cbWhite)
        cbYellow = view.findViewById(R.id.cbYellow)
        cbOrange = view.findViewById(R.id.cbOrange)
        cbGreen = view.findViewById(R.id.cbGreen)

        val bundle = arguments
        name = bundle?.getString("name", "").toString()
        cricketer = bundle?.getString("cricketer","").toString()

        btNext.setOnClickListener(View.OnClickListener {

            if (cbGreen.isChecked || cbOrange.isChecked || cbYellow.isChecked || cbWhite.isChecked) {

                if(cbGreen.isChecked){
                    (colorsList as MutableList<String>).add(cbGreen.text.toString())
                }

                if(cbOrange.isChecked){
                    (colorsList as MutableList<String>).add(cbOrange.text.toString())
                }

                if(cbYellow.isChecked){
                    (colorsList as MutableList<String>).add(cbYellow.text.toString())
                }

                if(cbWhite.isChecked){
                    (colorsList as MutableList<String>).add(cbWhite.text.toString())
                }

                for(i in colorsList){
                    colors = if(!colors.isNullOrBlank()) {
                        "$colors , $i"
                    }else i
                }

                var detailsModel = DetailsModel()
                detailsModel.name = name
                detailsModel.colors = colors
                detailsModel.cricketer = cricketer

                lifecycleScope.launch(Dispatchers.Default){
                    saveDataToDb(detailsModel)
                }


                    var i : Intent = Intent(activity, SummaryActivity::class.java)
                    i.putExtra("name",""+name)
                    i.putExtra("cricketer",""+cricketer)
                    i.putExtra("colors",""+colors)
                    startActivity(i)
                    activity?.finish()


            } else {
                Toast.makeText(activity, "Please select atleast one color to proceed", Toast.LENGTH_LONG)
            }

        });

    }

    suspend fun saveDataToDb(detailsModel: DetailsModel){
        val dbHelper = DatabaseHelperImpl(DatabaseBuilder.getInstance(activity!!))
        dbHelper.insert(detailsModel)

    }
}