package com.example.moptu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moptu.adapters.RecyclerAdapter
import java.time.format.DateTimeFormatter
import java.util.Date

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        val dataset = ArrayList<ArticleDataClass>()
        dataset.add(ArticleDataClass("ODBIERZ SADZONKĘ DRZEWA I BILET NA OLSZTYN GREEN FESTIVAL 2024!", "W sobotę, 1 czerwca, organizatorzy Olsztyn Green Festivalu razem z Nałęczowianką zapraszają olsztynian i gości do wspólnej akcji sadzenia drzew."))
        dataset.add(ArticleDataClass("ZMIANY W ORGANIZACJI RUCHU I KOMUNIKACJI PUBLICZNEJ 1 CZERWCA!", "10.30 – Nie będzie możliwości dojazdu do miejsc postojowych w okolicy Tartaku Raphaelsohnów. 12.00-14.00 - Przemarsz trasą: Knosały – Niepodległości – Kościuszki – Emilii Plater – Piłsudskiego – Plac Jana Pawła II – Pieniężnego – Knosały."))
        dataset.add(ArticleDataClass("OD WRZEŚNIA DARMOWE PRZEJAZDY KOMUNIKACJĄ MIEJSKĄ DLA MŁODZIEŻY!", "Uczniowie olsztyńskich szkół ponadpodstawowych będą podróżować komunikacją zbiorową bez opłat."))
        dataset.add(ArticleDataClass("DOTACJE NA OLSZTYŃSKIE ZABYTKI PODZIELONE!", "Olsztyńscy radni zdecydowali o dofinansowaniu prac przy zabytkowych obiektach. Kwota została przeznaczona do podziału to 200 tys. złotych."))
        dataset.add(ArticleDataClass("CENTRUM PRZYWDZIEJE NOWĄ SZATĘ!", "W donicach w pobliżu ratusza pojawiły się bratki w odcieniach żółci i fioletu. Latem ich miejsce zajmie nowa roślinność."))
        dataset.add(ArticleDataClass("PIKNIK RODZINNY Z OKAZJI 20-LECIA POLSKI W UE ODBYŁ SIĘ W OLSZTYNIE!", "Na Starym Mieście i w Parku Podzamcze w Olsztynie odbył się Piknik Rodzinny z okazji 20-lecia członkostwa Polski w UE"))

        val customAdapter = RecyclerAdapter(dataset)

        val recyclerView: RecyclerView = rootView.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = customAdapter

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}