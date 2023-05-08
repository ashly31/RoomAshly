package Dao

import Entidad.EntidadPrimera
import androidx.room.*

@Dao
interface DaoPrimera {
    @Query("SELECT * FROM tblPrimera ORDER BY id DESC")
    fun getAllPrimerInfo(): List<EntidadPrimera>?

    @Insert
    fun insertPrimer(primer: EntidadPrimera?)

    @Delete
    fun deletePrimer(primer: EntidadPrimera?)

    @Update
    fun updatePrimer(primer: EntidadPrimera?)

}