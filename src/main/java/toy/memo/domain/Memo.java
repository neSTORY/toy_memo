package toy.memo.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Memo {

    private long id;
    private String writer;
    private String title;
    private String content;

    public Memo(String writer, String title, String content) {
        this.writer = writer;
        this.title = title;
        this.content = content;
    }
}
