package naver.et0709.board;

import jakarta.persistence.*;
import lombok.*;

//이 클래스가 데이터베이스 와 연동되는 클래스라는 것을 명시
@Entity
//테이블 이름
@Table(name= "board")
//인스턴스 출력할 때 사용할 메서드
@ToString
//접근자 메서드
@Getter
@Setter
//생성자를 이용해서 값을 대입하지 않고 .을 이용해서 메서드를 연속적으로 호출해서 값을 설정
@Builder
//모든 속성을 대입받아서 생성하는 생성자
@AllArgsConstructor
//매개변수 없는 생성자를 생성
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String title;

    @Column(length = 50, nullable = false)
    private String content;
}
