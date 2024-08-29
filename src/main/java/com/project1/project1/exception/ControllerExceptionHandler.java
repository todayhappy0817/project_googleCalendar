package com.project1.project1.exception;


import com.project1.project1.utils.restResponse.ResponseDto;
import com.project1.project1.utils.restResponse.RestResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DuplicationException.class)
    protected ResponseEntity<ResponseDto> duplicationException(DuplicationException e) {
        //로깅
        return RestResponseUtil.Fail();
    }
    @ExceptionHandler(NoSuchElementFoundException.class)
    protected ResponseEntity<ResponseDto> elementNotFoundException(NoSuchElementFoundException e) {
        //로깅
        return RestResponseUtil.Fail();
    }
    @ExceptionHandler(MissingServletRequestParameterException.class)
    protected ResponseEntity<ResponseDto> missing(MissingServletRequestParameterException e) {
        //로깅
        return RestResponseUtil.Fail();
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        return RestResponseUtil.Fail();
    }
}
/*

 */

/*@ControllerAdvice에서 예외를 처리하더라도, RestResponseUtil 사용하여
* 응답 형식의 일관성 유지
* 중복 코드 제거
* 책임 분리
* 변경에 대한 유연성
* 의 장점이 있기 때문에 같이 사용하는 것이 좋아보임
*/