package com.example.roomashly.Dao

import androidx.room.*
import com.example.roomashly.Entidad.PrimeraEntidad

@Dao
interface PrimerDao {
    @Query("SELECT * FROM tblPrimera ORDER BY id DESC")
    fun getAllPrimerInfo(): List<PrimeraEntidad>?

    @Insert
    fun insertPrimer(primer: PrimeraEntidad?)

    @Delete
    fun deletePrimer(primer: PrimeraEntidad?)

    @Update
    fun updatePrimer(primer: PrimeraEntidad?)

}