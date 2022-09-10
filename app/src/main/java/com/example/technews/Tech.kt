package com.example.technews

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.technews.data.News
import com.example.technews.data.repository.NewsRetriever
import com.example.technews.databinding.FragmentTechBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class Tech : Fragment() {

    companion object {
        fun newInstance() = Tech()
    }

    //    private lateinit var viewModel: TechViewModel
    private lateinit var binding: FragmentTechBinding
    private lateinit var newsData: News

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val view = inflater.inflate(R.layout.fragment_tech,container,false)

        binding = FragmentTechBinding.inflate(inflater)
        val recyclerView = binding.recyclerView
        val fragmentJob = Job()
        val coroutineScope = CoroutineScope(fragmentJob+Dispatchers.Main)
        recyclerView.layoutManager = LinearLayoutManager(view?.context)
        coroutineScope.launch {
            newsData = NewsRetriever().getNews()
            recyclerView.adapter = TechRvAdapter(newsData)
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        binding = FragmentTechBinding.inflate(layoutInflater)
//        val viewmodelFactory = TechViewModelFactory(binding.recyclerView)
//        viewModel = ViewModelProvider
//    }

}