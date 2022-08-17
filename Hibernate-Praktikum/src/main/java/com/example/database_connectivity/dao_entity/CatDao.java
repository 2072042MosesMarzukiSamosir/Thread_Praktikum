package com.example.database_connectivity.dao_entity;

import com.example.database_connectivity.model_entity.CategoryEntity;
import com.example.database_connectivity.utility.HiberUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class CatDao implements DaoService<CategoryEntity>{
    @Override
    public List<CategoryEntity> getdata() {
        List<CategoryEntity>Clist;

        SessionFactory sf = HiberUtility.getSessionFactory();
        Session s =sf.openSession();

        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery(CategoryEntity.class);
        query.from(CategoryEntity.class);

        Clist = s.createQuery(query).getResultList();
        return Clist;
    }

    @Override
    public void addData(CategoryEntity data) {
        SessionFactory sf = HiberUtility.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        try{
            s.save(data);
            t.commit();
        }catch (Exception exception){
            t.rollback();
        }
        s.close();
    }

    @Override
    public void deleteData(CategoryEntity data) {
        SessionFactory sf = HiberUtility.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        try{
            s.delete(data);
            t.commit();
        }catch (Exception exception){
            t.rollback();
        }
        s.close();
    }

    @Override
    public void updateData(CategoryEntity data) {
        SessionFactory sf = HiberUtility.getSessionFactory();
        Session s = sf.openSession();
        Transaction t = s.beginTransaction();
        try{
            s.update(data);
            t.commit();
        }catch (Exception exception){
            t.rollback();
        }
        s.close();
    }
}
