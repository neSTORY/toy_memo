package toy.memo.repository;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import toy.memo.domain.Memo;

import java.util.List;

class MemoryMemoRepositoryTest {

    MemoRepository store = new MemoryMemoRepository();

    @AfterEach
    void clearStore() {
        store.clear();
    }

    @Test
    void save() {
        //given
        Memo memo = new Memo("eunsu", "todo", "토이프로젝트 진행하기");

        //when
        Memo savedMemo = store.save(memo);
        System.out.println(savedMemo);

        //then
        Memo findMemo = store.findById(savedMemo.getId());
//        assertThat(findMemo).isEqualTo(savedMemo);

    }

    @Test
    void update() {
        //given
        Memo memo = new Memo("eunsu", "todo", "토이프로젝트 진행하기");
        store.save(memo);

        Memo updateMemo = new Memo("ensu", "todo", "토이프로젝트 깃 레포지토리 생성");
        //when
        store.update(memo.getId(), updateMemo);

        //then
        Memo findMemo = store.findById(memo.getId());
        assertThat(findMemo.getContent()).isNotEqualTo("토이프로젝트 진행하기");
    }

    @Test
    void findAll () {
        //given
        Memo memo1 = new Memo("eunsu", "todo", "토이프로젝트 진행하기");
        Memo memo2 = new Memo("dongyoon", "todo", "병원가기");
        Memo memo3 = new Memo("gaeun", "todo", "카페가기");

        //when
        store.save(memo1);
        store.save(memo2);
        store.save(memo3);

        //then
        List<Memo> memos = store.findAll();
        assertThat(memos.size()).isEqualTo(3);
    }

}