package com.example.myapplication.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.*
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.MainActivity
import com.example.myapplication.MyDataItem
import com.example.myapplication.R
import com.example.myapplication.adapter.ListAdapter
import com.example.myapplication.adapter.NavAdapter
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplicationnewnew.adapter.PhotoItemDecoration

class homefragment(
    private val context:MainActivity
) : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter : ListAdapter
    private lateinit var adapter1 : ListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.bind(view)

//créer une liste
        val photoList = arrayListOf<MyDataItem>()

        val filteredList = arrayListOf<MyDataItem>()

        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontale_recycler_view)
        horizontalRecyclerView.adapter = NavAdapter(context, photoList)
//        var search : EditText = view.findViewById(R.id.searchView)

        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView.adapter = ListAdapter(context, photoList)
        verticalRecyclerView.addItemDecoration(PhotoItemDecoration())

        adapter = ListAdapter(context,photoList)
        binding.verticalRecyclerView.adapter=adapter

        binding.searchView.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                Log.d("text",s.toString())

                filteredList.clear()
                if (s.toString().isEmpty()){
                    binding.verticalRecyclerView.adapter=adapter
                    adapter.notifyDataSetChanged()
                }
                else {
                    for ( photo in photoList){
                        if (photo.user.username.contains(s.toString()) ){
                            filteredList.add(photo)
                        }
                    }
                    adapter1 = ListAdapter(context,filteredList)
                    binding.verticalRecyclerView.adapter = adapter1
                    adapter1.notifyDataSetChanged()

                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })



        return view



    }




}
