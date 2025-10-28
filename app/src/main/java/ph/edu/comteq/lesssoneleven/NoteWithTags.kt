package ph.edu.comteq.lesssoneleven

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

/**
 * This class represents a Note with all its associated tags
 */
data class NoteWithTags(
    @Embedded val note: Note,

    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = NoteTagCrossRef::class,
            parentColumn = "note_id",
            entityColumn = "tag_id"
        )
    )
    val tags: List<Tag>
)