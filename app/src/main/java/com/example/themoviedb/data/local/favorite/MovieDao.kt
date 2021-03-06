package com.example.themoviedb.data.local.favorite

import androidx.room.*

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userEntity: MovieEntity)

    @Delete
    suspend fun delete(userEntity: MovieEntity)

    @Query("SELECT * from movieentity")
    suspend fun getFavorites(): List<MovieEntity>
}