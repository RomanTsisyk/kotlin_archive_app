package tsisyk.app.kanbanboard.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.launch
import tsisyk.app.kanbanboard.R
import tsisyk.app.kanbanboard.data.TaskDatabase

class ReviewFragment : BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_review, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recycleView.setHasFixedSize(true)
        recycleView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        launch {
            context?.let{
                val tasks = TaskDatabase(it).getTaskDao().getPEER_REVIREW()
                recycleView.adapter = TaskAdapter(tasks)
            }
        }

    }
}