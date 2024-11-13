package naver.et0709.board;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;


public class BoardServiceTest {
    @Mock
    private BoardRepository boardRepository;

    @InjectMocks
    private BoardService boardService;

    @Test
    public void testSaveBoard() {
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setTitle("Test Title");
        boardDTO.setContent("Test Content");
        Board board = Board.builder()
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent())
                .build();

        when(boardRepository.save(Mockito.any(Board.class))).thenReturn(board);

        Board savedBoard = boardService.saveBoard(boardDTO);
        assertThat(savedBoard).isNotNull();
        assertThat(savedBoard.getTitle()).isEqualTo("Test Title");

    }
    @Test
    public void testGetAllBoards() {
        Board board = new Board();
        board.setTitle("Test Title");
        board.setContent("Test Content");
        when(boardRepository.findAll()).thenReturn(List.of(board));

        // 테스트 수행
        List<Board> boards = boardService.getAllBoards();
        assertThat(boards).hasSize(1);
        assertThat(boards.get(0).getTitle()).isEqualTo("Test Title");
    }
}
