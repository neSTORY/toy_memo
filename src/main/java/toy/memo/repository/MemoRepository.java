package toy.memo.repository;

import java.util.List;
import toy.memo.domain.Memo;

public interface MemoRepository {

    List<Memo> findAll();

    Memo findById(Long id);

    Memo save(Memo memo);

    Memo delete(Long id);

    void update(Long id, Memo updateParam);

    void clear();

}
