package org.zerock.boardex.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude="board")

//Comparable() 객체 : 비교해야 하는 객체에 적용함. 주로 정렬을 위해서 사용(파일명 순서대로 오름차순 정렬)
public class BoardImage implements Comparable<BoardImage>{
    //@Id:로 인해 uuid가 주키가 됌
    @Id
    private String uuid;
    private String fileName;
    private int ord;
    //이 객체는 이미지 객체인데, ManyToOne인 이유는 게시글 1개당 이미지를 여러개 첨부할 수 있는데
    //Many = 이미지 to One = 게시글 이므로 여기선 ManyToOne 이 맞다.
    @ManyToOne
    private Board board;

    @Override
    public int compareTo(BoardImage other){
        return this.ord-other.ord;
    }
    public void changeBoard(Board board){
        this.board=board;
    }
}