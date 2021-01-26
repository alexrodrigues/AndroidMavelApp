package com.rodriguesalex.marvelapp.detail.domain

import br.com.rodriguesalex.components.section.vo.SectionViewVo
import com.rodriguesalex.marvelapp.detail.data.DetailVo
import com.rodriguesalex.marvelapp.detail.domain.mapper.toDetailVo
import com.rodriguesalex.marvelapp.home.data.HomeCharacterVO
import javax.inject.Inject

interface DetailInteractor {
    fun fetch(homeVo: HomeCharacterVO): DetailVo
}

class DetailInteractorImpl @Inject constructor(): DetailInteractor {

    override fun fetch(homeVo: HomeCharacterVO): DetailVo =
        homeVo.toDetailVo()
}