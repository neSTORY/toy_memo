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

}