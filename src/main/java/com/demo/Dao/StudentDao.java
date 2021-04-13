package com.demo.Dao;

import com.demo.Entity.StudentEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class StudentDao {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
    EntityManager em = emf.createEntityManager();

    public void insertStudent(StudentEntity student){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    public void updateStudent(int id, StudentEntity updatingStudent){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        StudentEntity studentUpdate = em.find(StudentEntity.class, id);
        if(studentUpdate != null){
            studentUpdate.setName(updatingStudent.getName());
            studentUpdate.setAge(updatingStudent.getAge());
            studentUpdate.setAddress(updatingStudent.getAddress());
            studentUpdate.setPhone(updatingStudent.getPhone());
            studentUpdate.setClassId(updatingStudent.getClassId());
        }
        em.getTransaction().commit();
        em.close();
    }

    public void deleteStudent(int id){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        StudentEntity studentDelete = em.find(StudentEntity.class, id);
        if (studentDelete != null){
            em.remove(studentDelete);
            em.getTransaction().commit();
        }
        em.close();
    }

    public List<StudentEntity> getStudents(){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        List<StudentEntity> list = em.createQuery("select s from StudentEntity s", StudentEntity.class).getResultList();
        em.getTransaction().commit();
        em.close();
        return list;
    }

    public StudentEntity getStudentById(int id){
        em = emf.createEntityManager();
        em.getTransaction().begin();
        StudentEntity studentEntity = em.createQuery("select s from StudentEntity s where s.id = " + id, StudentEntity.class).getSingleResult();
        em.getTransaction().commit();
        em.close();
        return studentEntity;
    }
}
