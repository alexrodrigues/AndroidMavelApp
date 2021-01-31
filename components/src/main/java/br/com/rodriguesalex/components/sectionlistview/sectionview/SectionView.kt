package br.com.rodriguesalex.components.sectionlistview.sectionview

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.rodriguesalex.components.R
import br.com.rodriguesalex.components.sectionlistview.sectionview.adapter.SectionViewAdapter
import br.com.rodriguesalex.components.sectionlistview.sectionview.vo.SectionViewVo
import kotlinx.android.synthetic.main.view_component_section.view.*

class SectionView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    var title: String = ""
        set(value) {
            field = value
            tvSectionTitle.text = value
        }

    init {
        LayoutInflater.from(context).inflate(R.layout.view_component_section, this)

        val typedArray = context.obtainStyledAttributes(
            attrs, R.styleable.SectionView, defStyleAttr, 0
        )

        typedArray.getString(R.styleable.SectionView_sectionTitle)?.let {
            title = it
        }

        typedArray.recycle()
    }

    fun bind(vo: SectionViewVo) {
        tvSectionTitle.text = resources.getString(vo.sectionTitle)

        val linearLayout = LinearLayoutManager(context).also {
            it.orientation = LinearLayoutManager.HORIZONTAL
        }

        rvSectionItems.apply {
            layoutManager = linearLayout
            adapter = SectionViewAdapter(vo.items)
        }
    }
}