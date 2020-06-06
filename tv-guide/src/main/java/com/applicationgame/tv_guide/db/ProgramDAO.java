package com.applicationgame.tv_guide.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.applicationgame.tv_guide.models.Program;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface ProgramDAO {

    @Query("SELECT * FROM programs")
    LiveData<List<Program>> getAllProg();

    @Query("SELECT * FROM programs WHERE programs.channelId = :channelId")
    LiveData<List<Program>> getAllProgWithChannelId(int channelId);

    @Insert(onConflict = REPLACE)
    void insert(Program program);

    @Delete
    void delete(Program program);

    @Update(onConflict = REPLACE)
    void updateEvent(Program program);
}