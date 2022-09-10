package com.example.technews

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TechViewModelFactory(val arg: View):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(View::class.java)
            .newInstance(arg)
    }
}