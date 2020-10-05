package com.ydnm4528.typicoderetrofit.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ydnm4528.typicoderetrofit.R
import com.ydnm4528.typicoderetrofit.adapter.HospitalAdapter
import com.ydnm4528.typicoderetrofit.model.HospitalsItem
import com.ydnm4528.typicoderetrofit.viewmodel.HospitalViewModel
import kotlinx.android.synthetic.main.fragment_hospital.*


class HospitalFragment : Fragment() {

    lateinit var hospitalViewModel: HospitalViewModel
    lateinit var hospitalAdapter: HospitalAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hospital, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        hospitalViewModel = ViewModelProvider(this)
            .get(HospitalViewModel::class.java)

        hospitalAdapter = HospitalAdapter()

        RecyclerHospital.layoutManager = LinearLayoutManager(context)
        RecyclerHospital.adapter = hospitalAdapter

        hospitalViewModel.getHospital().observe(
            viewLifecycleOwner, Observer {
                hospitalAdapter.updateHospital(it.hospitals as List<HospitalsItem>)
            }
        )
    }

    override fun onResume() {
        super.onResume()
        hospitalViewModel.loadHospital()
    }
}


