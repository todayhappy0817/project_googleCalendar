package com.project1.project1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author :  이준원(junwon@mteletec.com)
 * @name :
 * <PRE>
 * </PRE>
 * @class :
 * @date :
 * @history <PRE>
 * No  Date        time       Author                             Desc
 * --- ----------- ---------- ---------------------------------- -----
 * 1       이준원(junwon@mteletec.com)    최초작성
 * </PRE>
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DuplicationException extends RuntimeException{
    public DuplicationException(String msg){
        super(msg);
    }
}
