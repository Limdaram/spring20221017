package com.example.spring20221017.service.member;

import com.example.spring20221017.domain.member.MemberDto;
import com.example.spring20221017.mapper.member.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberMapper mapper;

    public int insert(MemberDto member) {
        return mapper.insert(member);
    }

    public List<MemberDto> list() {
        return mapper.selectAll();
    }

    public MemberDto getById(String id) {
        return mapper.selectById(id);
    }

    public MemberDto getByEmail(String email) {
        return mapper.selectByEmail(email);
    }

    public int modify(MemberDto member) {
        int cnt = 0;
        try {
            return mapper.update(member);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cnt;
    }

    public int remove(String id) {
        return mapper.delete(id);
    }
}
