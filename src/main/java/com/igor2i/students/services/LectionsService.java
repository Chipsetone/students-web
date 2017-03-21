package com.igor2i.students.services;

import com.igor2i.students.modules.pojo.university.Lections;
import com.igor2i.students.modules.pojo.university.objects.Lection;
import com.igor2i.students.modules.pojo.university.springdata.LectionRepository;
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
    private static final Logger logger = LogManager.getLogger(LectionsService.class);

    @Autowired
    private Lections lections;
    @Autowired
    private LectionRepository lectionRepository;

    public  ArrayList<Lection> getAllLections(){
        ArrayList<Lection> result = new ArrayList<>(10);
        try {
            Iterable<Lection> lections = lectionRepository.findAll();
            for (Lection lec :
                    lections) {
                result.add(lec);
            }
        } catch (Exception e) {
            logger.error("Что-то хреновое при попытке получить все лекции", e);
        }
        return result;

    }

    public Lection getById(int id){
        Lection lection = null;

        try {
            lection = lections.getById(id);

        } catch (SQLException e) {
            logger.error(e.getMessage());
//            e.printStackTrace();
        }
        return lection;

    }

    public void updateLection(int id, Lection lection){
        try {
            lections.setUpdateById(id,lection);
        } catch (SQLException e) {
            logger.error(e.getMessage());
//            e.printStackTrace();
        }
    }

    public void newLection(Lection lection){
        try {
            lections.setNewColumn(lection);
        } catch (SQLException e) {
            logger.error(e.getMessage());
//            e.printStackTrace();
        }
    }

    public void delLection(int id){

        try {
            lections.delById(id);

        } catch (SQLException e) {
            logger.error(e.getMessage());
//            e.printStackTrace();
        }

    }

}
