package org.zerock.boardex.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.zerock.boardex.domain.Board;
import org.zerock.boardex.repository.search.BoardSearch;

import java.util.Optional;

//Mapper처럼 데이터베이스 관련 작업 처리(CRUD와 페이징 처리)
public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {
    @Query(value="select now()", nativeQuery=true)
    String getTime();
    //첨부파일 수정
    @EntityGraph(attributePaths = {"imageSet"})
    //Board의 이름을 b로 설정하고 bno(글번호)기준으로 bno값과 같은 것을 조회해달라는것
    @Query("select b from Board b where b.bno = :bno")
    Optional<Board> findByIdWithImages(@Param("bno") Long bno);

    //첨부파일 삭제
    //게시글에 댓글이나 첨부파일이 있으면 게시글 삭제 안됌
    //게시글을 삭제하려면 먼저 댓글이나 첨부파일을 삭제 한 다음 게시글 삭제 가능
}
