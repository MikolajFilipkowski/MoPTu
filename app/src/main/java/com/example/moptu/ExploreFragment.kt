package com.example.moptu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moptu.adapters.ExploreCategoriesAdapter
import com.example.moptu.adapters.RecyclerAdapter
import java.util.Dictionary

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ExploreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExploreFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var explore_view:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_explore, container, false)


        val dict = ArrayList<ArrayList<String>>()

        dict.add(arrayListOf("WYSOKA BRAMA","brama",getString(R.string.wysoka_brama)))
        dict.add(arrayListOf("ŁAWECZKA MIKOŁAJA KOPERNIKA","lawka",getString(R.string.laweczka)))
        dict.add(arrayListOf("ZAMEK KAPITUŁY WARMIŃSKIEJ","zamek",getString(R.string.zamek)))
        dict.add(arrayListOf("STARY RATUSZ","ratusz",getString(R.string.ratusz)))
        dict.add(arrayListOf("DOM GAZETY OLSZTYŃSKIEJ","gazeta",getString(R.string.gazeta)))


        val customAdapter = ExploreCategoriesAdapter(dict, context)

        val recyclerView: RecyclerView = rootView.findViewById(R.id.explore_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = customAdapter
        // Inflate the layout for this fragment
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        explore_view = view.findViewById(R.id.explore_view)

        //explore_view.adapter = Adapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ExploreFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ExploreFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}