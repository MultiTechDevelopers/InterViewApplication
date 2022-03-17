package com.wcg.interviewdharmarajmangukiya.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.wcg.interviewdharmarajmangukiya.R
import com.wcg.interviewdharmarajmangukiya.data.network.responses.BreedResponse
import com.wcg.interviewdharmarajmangukiya.databinding.RcvBreedItemBinding
import com.wcg.interviewdharmarajmangukiya.ui.interfaces.BreedsClicks
import com.wcg.interviewdharmarajmangukiya.utils.setImage

class BreedsAdapter(
    private val breedList: ArrayList<BreedResponse.BreedResponseItem>,
    private val breedsClicks: BreedsClicks
) : RecyclerView.Adapter<BreedsAdapter.BreedsHolder>() {

    class BreedsHolder(val binding: RcvBreedItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BreedsHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.rcv_breed_item, parent, false
        )
    )

    override fun onBindViewHolder(holder: BreedsHolder, position: Int) {
        with(holder.binding) {
            setImage(imgBreed, breedList[position].image?.url)
            txtBreedName.text = breedList[position].name

            crdBreeds.setOnClickListener {
                breedsClicks.getBreedPosition(position)
            }
        }
    }

    override fun getItemCount(): Int = breedList.size
}
