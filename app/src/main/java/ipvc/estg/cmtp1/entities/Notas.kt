package ipvc.estg.cmtp1.entities

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notas_table")

class Notas (

    @PrimaryKey(autoGenerate = true) val id:Int? = null,
    @ColumnInfo(name= "title") val title:String,
    @ColumnInfo(name= "desc") val desc:String
)