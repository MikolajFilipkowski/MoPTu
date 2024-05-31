package com.example.moptu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_DATASET = "param1"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailsFragment() : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: ArrayList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getStringArrayList(ARG_DATASET)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_details, container, false)

        val title = rootView.findViewById<TextView>(R.id.details_title)
        val image = rootView.findViewById<ImageView>(R.id.details_image)
        val content = rootView.findViewById<TextView>(R.id.details_content)

        title.text = param1?.get(0)
        val imageResource = resources.getIdentifier(param1?.get(1) ?: "zamek","drawable",rootView.context.packageName)
        image.setImageResource(imageResource)
        content.text = param1?.get(2)
        // Inflate the layout for this fragment
        return rootView
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(dataSet: ArrayList<String>) =
            DetailsFragment().apply {
                arguments = Bundle().apply {
                    putStringArrayList(ARG_DATASET, dataSet)
                }
            }
    }
}