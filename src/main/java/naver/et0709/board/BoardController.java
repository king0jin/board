package naver.et0709.board;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/get/board")
    public List<Board> getAllBoards() {
        return boardService.getAllBoards();
    }
    @PostMapping("/post/board")
    public String createBoard(@RequestBody BoardDTO boardDTO) {
        boardService.saveBoard(boardDTO);
        return "success";
    }
    @DeleteMapping("/delete/board/{id}")
    public void deleteBoard(@PathVariable Long id) {
        boardService.delete(id);
    }
}
