package org.zerock.boardex.service;

import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.zerock.boardex.dto.MemberJoinDTO;

public interface MemberService {
    //MidExistException:회원이 이미 존재하는 경우 예외처리함.
    static class MidExistException extends Exception{
    }
    void join(MemberJoinDTO memberJoinDTO) throws MidExistException;
}
