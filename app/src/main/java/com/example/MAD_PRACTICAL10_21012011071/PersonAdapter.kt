package com.example.MAD_PRACTICAL10_21012011071

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import java.util.ArrayList

class PersonAdapter(context: Context, array: ArrayList<Person>) :
    ArrayAdapter<Person>(context, 0, array) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.person_item, parent, false)

        val personData = getItem(position)

        val nameTextView = view.findViewById<TextView>(R.id.textView_name)
        val phoneNoTextView = view.findViewById<TextView>(R.id.textView_no)
        val emailTextView = view.findViewById<TextView>(R.id.textView_email)
        val addressTextView = view.findViewById<TextView>(R.id.textView_address)
        val locationButton = view.findViewById<MaterialButton>(R.id.btn_location)

        nameTextView.text = personData?.name
        phoneNoTextView.text = personData?.phoneNo
        emailTextView.text = personData?.emailId
        addressTextView.text = personData?.address

        locationButton.setOnClickListener {
            val intent = Intent(context, MapsActivity::class.java)
            intent.putExtra("Object", personData)
            context.startActivity(intent)
        }

        return view
    }
}
