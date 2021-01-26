package com.rodriguesalex.marvelapp.detail.domain.mapper

import br.com.rodriguesalex.components.section.vo.SectionItemViewVo
import br.com.rodriguesalex.components.section.vo.SectionViewVo
import com.rodriguesalex.marvelapp.R
import com.rodriguesalex.marvelapp.detail.data.DetailVo
import com.rodriguesalex.marvelapp.home.data.HomeCharacterVO

fun HomeCharacterVO.toDetailVo(): DetailVo =
    DetailVo(
        title = name,
        imageUrl = urlImage,
        details = toSectionViewVo()
    )

fun HomeCharacterVO.toSectionViewVo(): List<SectionViewVo> {
    val sectionComics = SectionViewVo(
        sectionTitle = R.string.section_comics,
        items = details?.comics?.extractToVO(urlImage) ?: listOf()
    )

    val sectionStories = SectionViewVo(
        sectionTitle = R.string.section_stories,
        items = details?.stories?.extractToVO(urlImage) ?: listOf()
    )

    val sectionSeries = SectionViewVo(
        sectionTitle = R.string.section_series,
        items = details?.series?.extractToVO(urlImage) ?: listOf()
    )

    return listOf(
        sectionComics, sectionSeries, sectionStories
    )
}


private fun List<String>.extractToVO(urlImage: String) =
    map {
        SectionItemViewVo(
            title = it,
            imageUrl = urlImage
        )
    }
