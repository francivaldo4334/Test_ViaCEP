package br.com.fcr.testapiviacep.data.model

import br.com.fcr.testapiviacep.domain.model.UCModelList

class dataModelList : ArrayList<dataModel>()

fun dataModelList.toUCModelList():UCModelList{
    val ucModelList = UCModelList()
    forEach{
        ucModelList.add(it.toUCModel())
    }
    return ucModelList
}