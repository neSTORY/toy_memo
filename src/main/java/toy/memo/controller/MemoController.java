package toy.memo.controller;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import toy.memo.domain.Memo;
import toy.memo.repository.MemoryMemoRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemoController {

    private final MemoryMemoRepository memoRepository;

    @GetMapping("/memo/memos")
    public String showMemos(Model model) {
        List<Memo> memos = memoRepository.findAll();
        model.addAttribute("memos", memos);
        return "memo/memos";
    }

    @GetMapping("/memo/memos/{memoId}")
    public String showItem(@PathVariable Long memoId, Model model) {
        Memo memo = memoRepository.findById(memoId);
        model.addAttribute("memo", memo);
        return "memo/memo";
    }

    @GetMapping("/memo/add")
    public String showAddForm() {
        return "/memo/addForm";
    }

    @PostMapping("/memo/add")
    public String add(@ModelAttribute Memo memo) {
        memoRepository.save(memo);
        return "/memo/memo";
    }

    @GetMapping("/memo/memos/{memoId}/edit")
    public String showEditForm(@PathVariable Long memoId, Model model) {
        Memo memo = memoRepository.findById(memoId);
        model.addAttribute("memo", memo);
        return "/memo/editForm";
    }

    @PostMapping("/memo/memos/{memoId}/edit")
    public String edit(@PathVariable Long memoId, @ModelAttribute Memo memo) {
        memoRepository.update(memoId, memo);
        return "redirect:/memo/memos/{memoId}";
    }

    @PostConstruct
    public void init() {
        Memo memo1 = new Memo("eunsu", "to do", "study database");
        Memo memo2 = new Memo("dongyoon", "today workout", "run 5km");

        memoRepository.save(memo1);
        memoRepository.save(memo2);
    }


}
