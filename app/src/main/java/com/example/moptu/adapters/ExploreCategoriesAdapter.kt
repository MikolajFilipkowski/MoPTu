package com.example.moptu.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.moptu.ArticleDataClass
import com.example.moptu.DetailsFragment
import com.example.moptu.R
import com.google.android.material.card.MaterialCardView

class ExploreCategoriesAdapter(private val dataSet: ArrayList<ArrayList<String>>, private val appContext: Context?) :
    RecyclerView.Adapter<ExploreCategoriesAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val categoryView: TextView
        val materialCardView: MaterialCardView

        init {
            // Define click listener for the ViewHolder's View
            categoryView = view.findViewById(R.id.categoryView)
            materialCardView = view.findViewById(R.id.categoryMaterialCardView)

            materialCardView.setOnClickListener {
                it.rootView.context
            }
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.explore_item, viewGroup, false)

        return ViewHolder(view)
    }


    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {


        viewHolder.materialCardView.setOnClickListener {
            (appContext as AppCompatActivity)?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragment_container, DetailsFragment.newInstance(dataSet[position]))
                ?.commit()
        }
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.categoryView.text = dataSet[position][0]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}