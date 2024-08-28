package com.project1.project1.exception;


public class CustomException  extends RuntimeException{

    public CustomException(String msg){
        //로깅 처리 실시할 예정
        System.out.println("CustomException 실시"+msg);
    }

}
