package com.example.demo.repository;

import com.example.demo.model.dataList;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class dataListRepository {
    public dataListRepository(){}


    @PersistenceUnit(unitName = "dataProject")
    private EntityManagerFactory entityManagerFactory;
    public ArrayList<dataList> getData() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<dataList> query=entityManager.createQuery("SELECT d from dataList d",dataList.class);
        ArrayList<dataList> result = (ArrayList<dataList>)query.getResultList();
        System.out.println(result);
        return result;
    }
    public ArrayList<dataList> getData(Integer userId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<dataList> query=entityManager.createQuery("SELECT d from dataList d JOIN FETCH d.user duser WHERE duser.id = :userId",dataList.class);
        query.setParameter("userId",userId);
        ArrayList<dataList> result = (ArrayList<dataList>)query.getResultList();
        return result;
    }
    public void createPost(dataList newPost) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction= entityManager.getTransaction();
        try{
            transaction.begin();
            ArrayList<dataList> re=getData();
            if(re.contains(newPost)) {
                throw new Exception();
            }
            else{
            entityManager.persist(newPost);
        }transaction.commit();
        }
        catch(Exception e){
            System.out.println(e);
            transaction.rollback();
        }
    }
    public void deletePost(Integer postId)
    {EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction= entityManager.getTransaction();
        try{
            transaction.begin();
            dataList post=entityManager.find(dataList.class,postId);
            entityManager.remove(post);
            transaction.commit();
        }
        catch(Exception e){
            System.out.println(e);
            transaction.rollback();
        }
    }
    public dataList getPost(Integer postId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<dataList> query=entityManager.createQuery("SELECT d from dataList d where d.id=:postId",dataList.class).setParameter("postId",postId);
        dataList da=query.getSingleResult();
        return da;
    }
    public void updatepost(dataList updatedPost) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction= entityManager.getTransaction();
        try{
            transaction.begin();
            entityManager.merge(updatedPost);
            transaction.commit();
        }
        catch(Exception e){
            System.out.println(e);
            transaction.rollback();
        }
    }

    public ArrayList<dataList> search(String keyword) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<dataList> query=entityManager.createQuery("SELECT d from dataList d where d.fullName=:keyword",dataList.class).setParameter("keyword",keyword);
        ArrayList<dataList> result = (ArrayList<dataList>)query.getResultList();
        System.out.println(result);
        return result;
    }
}
