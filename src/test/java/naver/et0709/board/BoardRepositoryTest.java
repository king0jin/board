package naver.et0709.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testSaveAndFind() {


        Board board = new Board(null, "Test Title", "Test Content");
        // 저장
        board = boardRepository.save(board);
        //데이터 조회
        assertThat(board.getId()).isNotNull();
    }
    @Test
    public void testFindAllBoards() {
        Iterable<Board> boards = boardRepository.findAll();
        assertThat(boards).isNotEmpty();
    }
}
