package com.rodriguesalex.marvelapp.detail.data

import br.com.rodriguesalex.components.sectionlistview.sectionview.vo.SectionViewVo

data class DetailVo (
    val title: String,
    val imageUrl: String,
    val details: List<SectionViewVo>)