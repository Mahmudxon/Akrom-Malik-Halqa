package uz.mahmudxon.halqa.business.datasource.db.story

import uz.mahmudxon.halqa.business.domain.model.Chapter
import uz.mahmudxon.halqa.business.domain.util.DomainMapper

class StoryEntityMapper : DomainMapper<StoryEntity, Chapter> {
    override fun mapToDomainModel(model: StoryEntity): Chapter {
        return Chapter(
            chapterNumber = model.id,
            title = model.title,
            description = model.description,
            story = "${model.story}"
        )
    }

    override fun mapFromDomainModel(domainModel: Chapter): StoryEntity {
        return StoryEntity(
            id = domainModel.chapterNumber,
            title = domainModel.title,
            description = domainModel.description,
            story = domainModel.story
        )
    }
}