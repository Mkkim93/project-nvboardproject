package hello.boardnv.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class Board {


    private Long id; // 글번호

    private String username; // 작성자
    private String title; // 제목
    private String content;
    private LocalDate dueDate; // 작성일
    private int checkedCount; // 조회수

    public Board(){};

    public Board(String username, String title, LocalDate dueDate, String content) {
        this.username = username;
        this.title = title;
        this.dueDate = dueDate;
        this.content = content;
    }
}
