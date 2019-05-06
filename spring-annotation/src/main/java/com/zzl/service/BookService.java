package com.zzl.service;

import com.zzl.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired(required = false)
    @Qualifier("bookDao")
    BookDao bookDao;

    public void print(){
        System.out.println(bookDao);
    }


    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao +
                '}';
    }
}
