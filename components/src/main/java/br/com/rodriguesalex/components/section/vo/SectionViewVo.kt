package br.com.rodriguesalex.components.section.vo

import androidx.annotation.StringRes

data class SectionViewVo(
    @StringRes val sectionTitle: Int,
    val items: List<SectionItemViewVo>)