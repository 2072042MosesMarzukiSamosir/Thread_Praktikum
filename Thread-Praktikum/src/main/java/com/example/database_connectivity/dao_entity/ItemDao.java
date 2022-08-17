package com.example.database_connectivity.dao_entity;

import com.example.database_connectivity.model_entity.CategoryEntity;
import com.example.database_connectivity.model_entity.ItemsEntity;
import com.example.database_connectivity.utility.HiberUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ItemDao implements DaoService<ItemsEntity>{
    @Override
    public List<ItemsEntity> getdata() {
        List<ItemsEntity>Ilist;

        SessionFactory sf = HiberUtility.getSessionFactory();
        Session s =sf.openSession();

        CriteriaBuilder cb = s.getCriteriaBuilder();
        CriteriaQuery query = cb.createQuery(ItemsEntity.class);
        query.from(ItemsEntity.class);

        Ilist = s.createQuery(query).getResultList();
        return Ilist;
    }

    @Override
    public void addData(ItemsEntity data) {
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
    public void deleteData(ItemsEntity data) {
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
    public void updateData(ItemsEntity data) {
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
