package com.igor2i.students.services;

import com.igor2i.students.modules.pojo.university.Lections;
import com.igor2i.students.modules.pojo.university.objects.Lection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by igor2i on 24.02.17.
 */
@Service
public class LectionsService {

    private static final Logger LOGGER = LogManager.getLogger(LectionsService.class);

    @Autowired
    private Lections lections;

    public  ArrayList<Lection> getAllLections(){


        ArrayList<Lection> lectionArrayList = new ArrayList<>(20);

        try {
            lectionArrayList.addAll(lections.getAll());


        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
            e.getStackTrace();
        }

        return lectionArrayList;

    }

    public Lection getById(int id){
        Lection lection = null;

        try {
            lection = lections.getById(id);

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
//            e.printStackTrace();
        }
        return lection;

    }

    public void updateLection(int id, Lection lection){
        try {
            lections.setUpdateById(id,lection);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
//            e.printStackTrace();
        }
    }

    public void newLection(Lection lection){
        try {
            lections.setNewColumn(lection);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
//            e.printStackTrace();
        }
    }

    public void delLection(int id){

        try {
            lections.delById(id);

        } catch (SQLException e) {
            LOGGER.error(e.getMessage());
//            e.printStackTrace();
        }

    }

}
