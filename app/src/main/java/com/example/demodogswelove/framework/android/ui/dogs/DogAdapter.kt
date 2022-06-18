package com.example.demodogswelove.framework.android.ui.dogs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestOptions
import com.example.demodogswelove.application.model.DogModel
import com.example.demodogswelove.databinding.ItemDogViewBinding
import com.example.demodogswelove.framework.glide.GlideInstance

/**
 * Created by Javier Pulido on 17/junio/2022
 */
class DogAdapter(private val dogs: List<DogModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private class DogViewHolder(val dataBinding: ItemDogViewBinding) :
        RecyclerView.ViewHolder(dataBinding.root)

    override fun getItemCount(): Int = dogs.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is DogViewHolder) {
            holder.dataBinding.apply {
                dogName = dogs[position].dogName
                dogDescription = dogs[position].description
                dogAge = dogs[position].age
                GlideInstance.imageBaseUrl?.let {
                    GlideInstance.glide.load(dogs[position].url)
                        .apply(RequestOptions.centerCropTransform()).transition(withCrossFade())
                        .into(imageView)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        DogViewHolder(
            ItemDogViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
}