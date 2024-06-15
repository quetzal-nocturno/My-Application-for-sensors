package com.example.myapplicationforsensors

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class SendorAdapter(context: Context, resource: Int, objects: List<SensorDetails>):
    ArrayAdapter<SensorDetails>(context, resource, objects) {
        private val mContext: Context = context;
        private val mResource: Int = resource;
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val sensorDetails = getItem(position)
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(mResource, parent, false)
        }
        val textView = view?.findViewById<TextView>(R.id.textView)
        sensorDetails?.let {
            textView?.text = it.toString()
        }
        return view!!
    }
}