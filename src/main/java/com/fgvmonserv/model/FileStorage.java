package com.fgvmonserv.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Arrays;

/**
 * Created by ievgenii.tsybaiev on 12.01.2017.
 */

@Entity
public class FileStorage {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "userId")
    private int userId;

    @Column(name = "file")
    private byte[] file;

    @Column(name = "createdTime", updatable = false)
    @GeneratedValue
    private LocalDate createdTime;

    public FileStorage(){}

    public FileStorage(int userId, byte[] file) {
        this.userId = userId;
        this.file = file;
    }


    public int getId() {
        return id;
    }

    public FileStorage setId(int id) {
        this.id = id;
        return this;
    }

    public int getUserId() {
        return userId;
    }

    public FileStorage setUserId(int userId) {
        this.userId = userId;
        return this;
    }

    public byte[] getFile() {
        return file;
    }

    public FileStorage setFile(byte[] file) {
        this.file = file;
        return this;
    }

    public LocalDate getCreatedTime() {
        return createdTime;
    }

    public FileStorage setCreatedTime(LocalDate createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileStorage that = (FileStorage) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (!Arrays.equals(file, that.file)) return false;
        return createdTime != null ? createdTime.equals(that.createdTime) : that.createdTime == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + Arrays.hashCode(file);
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FileStorage{" +
                "id=" + id +
                ", userId=" + userId +
                ", file=" + Arrays.toString(file) +
                ", createdTime=" + createdTime +
                '}';
    }
}
