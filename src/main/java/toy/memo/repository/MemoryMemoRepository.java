package toy.memo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import toy.memo.domain.Memo;

@Repository
public class MemoryMemoRepository implements MemoRepository {

    private static final Map<Long, Memo> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public List<Memo> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Memo findById(Long id) {
        return store.get(id);
    }

    @Override
    public Memo save(Memo memo) {
        memo.setId(++sequence);
        Memo put = store.put(memo.getId(), memo);
        return memo;
    }

    @Override
    public Memo delete(Long id) {
        return store.remove(id);
    }

    @Override
    public void update(Long id, Memo updateParam) {
        Memo findMemo = store.get(id);
        findMemo.setWriter(updateParam.getWriter());
        findMemo.setTitle(updateParam.getTitle());
        findMemo.setContent(updateParam.getContent());
    }

    @Override
    public void clear() {
        store.clear();
    }
}
