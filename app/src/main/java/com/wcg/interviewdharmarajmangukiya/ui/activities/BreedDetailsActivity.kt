package com.wcg.interviewdharmarajmangukiya.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wcg.interviewdharmarajmangukiya.data.network.responses.BreedResponse
import com.wcg.interviewdharmarajmangukiya.databinding.ActivityBreedDetailsBinding
import com.wcg.interviewdharmarajmangukiya.utils.Constants
import com.wcg.interviewdharmarajmangukiya.utils.setImage


class BreedDetailsActivity : AppCompatActivity() {

    private val TAG = "BreedDetailsActivity"

    private var binding: ActivityBreedDetailsBinding? = null
    private var objBreedDetails: BreedResponse.BreedResponseItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBreedDetailsBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        init()
        setup()
        onClickListeners()

    }

    private fun init() {
        objBreedDetails =
            intent.getSerializableExtra(Constants.ConstantValues.BREED_DETAILS) as BreedResponse.BreedResponseItem?
    }

    private fun setup() {
        setBreedUI()
    }

    private fun onClickListeners() {


    }

    private fun setBreedUI() {
        setImage(binding?.imgBreed, objBreedDetails?.image?.url)
        binding?.txtBreedName?.text = objBreedDetails?.name
        binding?.txtBreedDescription?.text = objBreedDetails?.description
        binding?.txtBreedCountry?.text = objBreedDetails?.country_code
        binding?.txtBreedOrigin?.text = objBreedDetails?.origin
    }
}