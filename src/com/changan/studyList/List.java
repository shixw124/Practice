package com.changan.studyList;
/*
 * @Author Administrator-shixw.
 * @Date 2018/8/26 0026.
 *
 */

public interface List {
    // the size of the list
    int size() ;

    // judge the  whether the list is empty
    boolean isEmpty();

    // insert element
    void insert(int index, Object object) throws Exception;

    // delete element
    void delete(int index) throws Exception;

    // get element
    Object get(int index) throws Exception;
}
