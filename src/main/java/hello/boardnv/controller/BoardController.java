package hello.boardnv.controller;

import hello.boardnv.domain.Board;
import hello.boardnv.repository.BoardRepository;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/basic")
@RequiredArgsConstructor
public class BoardController{

    private final BoardRepository boardRepository;

    // 게시글 리스트
    @GetMapping("/boardList")
    public void boards(Model model){
        List<Board> boards = boardRepository.findAll();
        model.addAttribute("boards", boards);
    }

    // 글 작성 페이지
    @GetMapping("/writeForm")
    public String boardWrite(Model model){

        model.addAttribute("board", new Board());

        return "/basic/writeForm";
    }

    // 글 저장 로직
    @PostMapping("/writepro")
    public String boardWritepro(Board board, RedirectAttributes redirectAttributes) {

        Board saveId = boardRepository.save(board);
        redirectAttributes.addAttribute("boardId", saveId.getId());
        redirectAttributes.addAttribute("status", true);

        return "redirect:/basic/boardList";
    }
}
