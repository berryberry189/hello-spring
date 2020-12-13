package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long,Member> store = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long Id) {
        // null 이어도 Optional 감싸서 반환하면 null point exception 안 떨어짐
        return Optional.ofNullable(store.get(Id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return  store.values().stream()
                    .filter(member -> member.getName().equals(name))
                    .findAny();

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
