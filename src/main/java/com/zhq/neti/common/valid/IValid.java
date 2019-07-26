package com.zhq.neti.common.valid;

public interface IValid<T> {
    boolean checkValid(T t,String colume);
}
