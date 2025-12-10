package com.example.myroom.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface SiswaDao {

    @Query("SELECT * from tbl_siswa ORDER BY nama ASC")
    fun getAllSiswa(): Flow<List<Siswa>>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(siswa: Siswa)

    @Update
    suspend fun update(siswa: Siswa)

    @Delete
    suspend fun delete(siswa: Siswa)

    @Query("SELECT * from tbl_siswa WHERE id = :id")
    fun getSiswa(id: Int): Flow<Siswa>

}