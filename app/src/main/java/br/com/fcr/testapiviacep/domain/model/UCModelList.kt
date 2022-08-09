package br.com.fcr.testapiviacep.domain.model

import br.com.fcr.testapiviacep.presentation.viewmodel.model.UiModelList

class UCModelList : ArrayList<UCModel>()

fun UCModelList.toUiModelList(): UiModelList {
    val uiModelList = UiModelList()
    forEach{
        uiModelList.add(it.toUiModel())
    }
    return uiModelList
}