package hello.boardnv.repository;

import hello.boardnv.domain.Board;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardRepository {

    private static Map<Long, Board> store = new HashMap<>();
    private static Long sequence = 0L;

    private BoardRepository(){}

    // 특정 게시글 조회
    public Board findById(Long id) {
        return store.get(id);
    }

    // 전체 게시글 조회
    public List<Board> findAll() {
        return new ArrayList<>(store.values());
    }

    // 게시글 저장 기능
    public Board save(Board board) {
        board.setId(++sequence);
        store.put(board.getId(), board);
        return board;
    }

    // 게시글 수정 기능
    public void update(Long boardId, Board updateBoard) {
       Board findBoard = findById(boardId);
       findBoard.setId(updateBoard.getId());
       findBoard.setUsername(updateBoard.getUsername());
       findBoard.setTitle(updateBoard.getTitle());
       findBoard.setDueDate(updateBoard.getDueDate());
    }

    public void clearStore() {
        store.clear();
    }

}


