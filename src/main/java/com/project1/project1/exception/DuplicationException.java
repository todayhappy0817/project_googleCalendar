package com.project1.project1.exception;


public class DuplicationException extends CustomException{
    public DuplicationException(String msg){
        super(msg); //CustomException에서 로깅 처리 후
        System.out.println("DuplicationException 실시"+msg);//DuplicationException만의 Exception 처리 실시 예정
    }
}
