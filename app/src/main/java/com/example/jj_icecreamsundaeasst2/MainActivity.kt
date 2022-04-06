package com.example.jj_icecreamsundaeasst2

import android.app.ListActivity
import android.app.Person
import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Size
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var total = 0.00
    var price = 0.00
    var fudge = 0.00
    var sizes = 0.00
    var cost = 0.00

    var orderList = arrayListOf<OrderHistory>()
    // updating the UI
    fun updateUI() {
        total = price + fudge + cost;
        textPrice.text =  ("$ " + "%.2f".format(total))
    }

    var spinnerItems = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //buttons and functions
        reset_button.setOnClickListener {
            total = 0.00
            pNut_Box.isChecked = false
            strawberry_Box.isChecked = false
            almonds_Box.isChecked = false
            gummy_Box.isChecked = false
            choco_Candy.isChecked = false
            brownies_Box.isChecked = false
            oreo_Box.isChecked = false
            mellow_Box.isChecked = false
            size_Spinner.setSelection(0)
            seekBar.setProgress(0)
            updateUI()
        }

        work_button.setOnClickListener {
            pNut_Box.isChecked = true
            strawberry_Box.isChecked = true
            almonds_Box.isChecked = true
            gummy_Box.isChecked = true
            choco_Candy.isChecked = true
            brownies_Box.isChecked = true
            oreo_Box.isChecked = true
            mellow_Box.isChecked = true
            size_Spinner.setSelection(2)
            seekBar.setProgress(3)
            updateUI()
        }

        order_button.setOnClickListener {
            Toast.makeText(this@MainActivity, "Order has been placed!",Toast.LENGTH_SHORT).show()
        }
        //Checkboxes declaration
        pNut_Box.setOnCheckedChangeListener { buttonView, isChecked ->
            if (pNut_Box.isChecked) {
                price += 0.15
            } else {
                price -= 0.15
            }
            updateUI()
        }

        strawberry_Box.setOnCheckedChangeListener { buttonView, isChecked ->
            if (strawberry_Box.isChecked) {
                price += 0.20
            } else {
                price -= 0.20
            }
            updateUI()
        }

        almonds_Box.setOnCheckedChangeListener { buttonView, isChecked ->
            if (almonds_Box.isChecked) {
                price += 0.15
            } else {
                price -= 0.15
            }
            updateUI()
        }

        gummy_Box.setOnCheckedChangeListener { buttonView, isChecked ->
            if (gummy_Box.isChecked) {
                price += 0.20
            } else {
                price -= 0.20
            }
            updateUI()
        }

        choco_Candy.setOnCheckedChangeListener { buttonView, isChecked ->
            if (choco_Candy.isChecked) {
                price += 0.25
            } else {
                price -= 0.25
            }
            updateUI()
        }

        brownies_Box.setOnCheckedChangeListener { buttonView, isChecked ->
            if (brownies_Box.isChecked) {
                price += 0.20
            } else {
                price -= 0.20
            }
            updateUI()
        }

        oreo_Box.setOnCheckedChangeListener { buttonView, isChecked ->
            if (oreo_Box.isChecked) {
                price += 0.20
            } else {
                price -= 0.20
            }
            updateUI()
        }

        mellow_Box.setOnCheckedChangeListener { buttonView, isChecked ->
            if (mellow_Box.isChecked) {
                price += 0.15
            } else {
                price -= 0.15
            }
            updateUI()
        }

        var size = arrayListOf("Small", "Medium", "Large")
        var spinnerAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, size)


        size_Spinner.adapter = spinnerAdapter

        size_Spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {


            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position == 0) {
                    cost = 2.99
                }
                else if (position == 1)
                {
                    cost = 3.99
                }

                else if (position == 2)  {
                    cost = 4.99
                }

                else {
                    cost = 0.00
                }
                updateUI()
            }


            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
        var flavor = arrayListOf("Vanilla", "Chocolate", "Strawberry")
        var spinnerAdapter1 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, flavor)
        flavor_Spinner.adapter = spinnerAdapter1

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(view: SeekBar?, position: Int, userclicked: Boolean) {
                if (position == 1) {

                    fudge = 0.15

                } else if (position == 2) {

                    fudge = 0.25

                } else if (position == 3) {

                    fudge = 0.30

                } else {
                    fudge = 0.0;
                }

                ounce_View.text = "$position oz"
                updateUI()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }


        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
            // function creates about activity and order history
        if (item.itemId == R.id.menu_about_id) {
            val intent = Intent(this@MainActivity, About::class.java)
            startActivity(intent)
            Toast.makeText(this@MainActivity,"This is Jordan's Ice Cream app menu",Toast.LENGTH_SHORT).show()
        }

        else {
            val intent = Intent(this@MainActivity, OrderActivity::class.java)
            orderList.add(OrderHistory(size_Spinner.selectedItem.toString(),flavor_Spinner.selectedItem.toString(), total))
            intent.putExtra("chocolate", orderList)
            startActivity(intent)

        }

        return true
    }


}


