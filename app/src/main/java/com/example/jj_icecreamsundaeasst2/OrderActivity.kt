package com.example.jj_icecreamsundaeasst2
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity() {
    var orderList = ArrayList<OrderHistory>()
    var orderListString = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val intent = intent
        orderList = intent.getSerializableExtra("chocolate") as ArrayList<OrderHistory>

        for (order in orderList)
        {
            orderListString.add(order.toString())
        }

        val adapter = ArrayAdapter<String>(this@OrderActivity, android.R.layout.simple_list_item_1, orderListString)
        listView.adapter = adapter
    }
}