package com.example.demodogswelove.framework.android.ui.dogs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demodogswelove.application.model.DogModel
import com.example.demodogswelove.databinding.ActivityDogsOverviewBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.scope.AndroidScopeComponent
import org.koin.androidx.scope.activityScope
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.scope.Scope

class DogsOverviewActivity : AppCompatActivity(), AndroidScopeComponent {
    override val scope: Scope by activityScope()
    private val viewModel by viewModel<DogsOverviewViewModel>()
    private lateinit var binding: ActivityDogsOverviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDogsOverviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        collectFlows()
        setListeners()
        lifecycleScope.launch(Dispatchers.IO) { viewModel.getDogs() }
    }

    private fun collectFlows() {
        lifecycleScope.apply {
            launch { viewModel.shoDogsList.collect { onShowDogsListCollected(it) } }
            launch { viewModel.showDogsServiceError.collect { onShowDogsServiceErrorCollected(it) } }
            launch { viewModel.showLoading.collect { onShowLoadingtCollected(it) } }
        }
    }

    private fun setListeners() {
        binding.backArrow.setOnClickListener {
            Toast.makeText(this, "Se realizará alguna acción...", Toast.LENGTH_LONG).show()
        }
    }

    private fun onShowDogsListCollected(dogs: List<DogModel>) {
        val dogsAdapter = DogAdapter(dogs)
        binding.dogsRecyclerView.adapter = dogsAdapter
        binding.dogsRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    private fun onShowDogsServiceErrorCollected(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show()
    }

    private fun onShowLoadingtCollected(visibility: Boolean) {
        binding.loadingProgressBar.visibility = if (visibility) View.VISIBLE else View.GONE
        binding.dogsConstraintLayout.visibility = if (visibility) View.GONE else View.VISIBLE
    }
}