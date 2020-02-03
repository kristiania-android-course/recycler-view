package com.avp.farm_animals.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.avp.farm_animals.AnimalActivity
import com.avp.farm_animals.AnimalAdapter
import com.avp.farm_animals.ImageClickListener
import com.avp.farm_animals.R
import kotlinx.android.synthetic.main.fragment_animal_list.view.*


/**
 *
 *
 * Created by:  Arun Pillai
 * Email: arun.vijayan.pillai@shortcut.no
 *
 * Date: 03 February 2020
 */
class AnimalListFragment : Fragment() , ImageClickListener {

    val animals : List<String> = mutableListOf("Chicken", "Cow", "Goat", "Sheep")

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_animal_list, container, false)

        val adapter = AnimalAdapter(requireContext(), animals, this)
        view.frag_recyclerview.layoutManager = GridLayoutManager(requireContext(), 2)
        view.frag_recyclerview.adapter = adapter
        return view
    }

    override fun itemClicked(position: Int) {
        //Toast.makeText(this, animals[position], Toast.LENGTH_SHORT).show()
        openAnimalActivity(animals[position])
    }

    private fun openAnimalActivity(name : String){
        val intent = Intent(requireContext(), AnimalActivity::class.java)
        intent.putExtra("name_of_animal", name)
        startActivity(intent)
    }


}