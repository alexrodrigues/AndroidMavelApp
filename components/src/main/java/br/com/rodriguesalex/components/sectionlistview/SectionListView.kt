package br.com.rodriguesalex.components.sectionlistview

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.rodriguesalex.components.sectionlistview.adapter.SectionListViewAdapter
import br.com.rodriguesalex.components.sectionlistview.sectionview.vo.SectionViewVo

class SectionListView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    init {
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.WRAP_CONTENT
        )
    }

    fun bind(list: List<SectionViewVo>) {
        adapter = SectionListViewAdapter(list)
    }
}