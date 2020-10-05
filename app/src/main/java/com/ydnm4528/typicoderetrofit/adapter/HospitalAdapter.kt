package com.ydnm4528.typicoderetrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ydnm4528.typicoderetrofit.model.HospitalsItem
import com.ydnm4528.typicoderetrofit.R
import kotlinx.android.synthetic.main.item_hospital.view.*

class HospitalAdapter : RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder> (){

    private var hospitalItems : List<HospitalsItem> = ArrayList()


    class HospitalViewHolder(itemView:View) : RecyclerView.ViewHolder (itemView)
    {
        fun bind (hospitalsItem: HospitalsItem)
        {
            itemView.hospitalName.text = hospitalsItem.hospitalName

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hospital, parent, false)
        return HospitalViewHolder(view)
    }

    override fun getItemCount(): Int {

        return hospitalItems.size
    }

    override fun onBindViewHolder(holder: HospitalViewHolder, position: Int) {
     holder.bind(hospitalItems[position])
    }

    fun updateHospital(hospitalList : List<HospitalsItem>)

    {
        this.hospitalItems = hospitalList
        notifyDataSetChanged()
    }


}