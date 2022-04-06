package com.example.jj_icecreamsundaeasst2

import java.io.Serializable

class OrderHistory(var size:String, var flavor:String, var price: Double): Serializable {
    override fun toString(): String {
        return "OrderHistory(size='$size', flavor='$flavor', price=$price)"
    }
}