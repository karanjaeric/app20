/*
 * Copyright (c) 2015 - 2015, Orion Tech Ltd. All rights reserved.
 * OrionWeb is a legal product of Orion Tech Ltd, Nairobi, Kenya. Orion Tech reserves the full rights on the product.
 */

package com.fundmaster.mss.dao;

import java.util.List;

/**
 * Created by bryanitur on 9/15/15.
 */
public interface GenericDAO<T> {

    T save(T entity);

    T merge(T entity);

    T findById(long id);

    boolean remove(T entity);

    List<T> findPaged(int start, int limit);

    List<T> findAll();

    List<T> customQuery(String s, String value);

    List<T> query(String query);

    List<T> findByObject(String s, Object o);

    long count();

}
