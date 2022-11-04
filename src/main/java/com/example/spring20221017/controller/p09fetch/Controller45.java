package com.example.spring20221017.controller.p09fetch;

import com.example.spring20221017.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.*;
import java.beans.JavaBean;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("ex45")
public class Controller45 {
    @RequestMapping("sub")
    public void method() {

    }
    @GetMapping("sub01")
    public ResponseEntity method01() {
        // return ResponseEntity.ok().build(); // 200번대 응답
        // return ResponseEntity.badRequest().build(); // 400번대 응답
        // return ResponseEntity.notFound().build(); // 404 notFound
         return ResponseEntity.status(500).build(); // 500번대 응답
    }
    @GetMapping("sub02")
    public ResponseEntity method02() {
        // return ResponseEntity.status(202).build(); // 202
        return ResponseEntity.accepted().build(); // 202
    }
    @GetMapping("sub03")
    public ResponseEntity method03() {
        return ResponseEntity
                .ok()
                .header("My-Header", "My-Value")
                .build();
    }
    @GetMapping("sub04")
    public ResponseEntity method04() {
        return ResponseEntity
                .ok()
                .header("Your-Header", "Your-Value")
                .build();
    }
    // 본문(body) 넘기기
    @GetMapping("sub05")
    public ResponseEntity<String> method05() {
        return ResponseEntity
                .ok()
                .header("Content-Type", "text/plain;charset=UTF-8")
                .body("안녕 임다람");
    }
    // type이 JavaBean일 때
    @GetMapping("sub06")
    public ResponseEntity<JavaBean24> method06() {
        JavaBean24 data = new JavaBean24();
        data.setLocation("seoul");
        data.setSince("2022년");
        return ResponseEntity
                .ok()
                .body(data);
    }
    @GetMapping("sub07")
    public ResponseEntity<JavaBean20> method07() {
        JavaBean20 data = new JavaBean20();
        data.setName("limdaram");
        data.setAddress("seoul");
        return ResponseEntity
                .ok()
                .body(data);
    }
    @GetMapping("sub08")
    public ResponseEntity<JavaBean27> method08() {
        JavaBean27 data = new JavaBean27();
        data.setName("daraming");
        data.setDate(LocalDate.now());
        data.setDateTime(LocalDateTime.now());
        return ResponseEntity
                .ok(data);
    }
    // JavaBean 안에 JavaBean
    @GetMapping("sub09")
    public ResponseEntity<JavaBean25> method09() {
        JavaBean25 data = new JavaBean25();
        JavaBean26 sub = new JavaBean26();
        data.setAge(26);
        data.setInfo(sub);

        sub.setAddress(List.of("서울", "인천"));
        sub.setMarried(true);

        return ResponseEntity
                .ok(data);
    }
    // 응답 본문(body)에만 집중
    @GetMapping("sub10")
    @ResponseBody
    public JavaBean25 method10 () {
        JavaBean25 data = new JavaBean25();
        JavaBean26 sub = new JavaBean26();
        data.setAge(26);
        data.setInfo(sub);

        sub.setAddress(List.of("서울", "인천"));
        sub.setMarried(true);

        return data;
    }
    @GetMapping("sub11")
    @ResponseBody
    public JavaBean27 method11 () {
        JavaBean27 data = new JavaBean27();
        data.setName("limdaram");
        data.setDate(LocalDate.now());
        data.setDateTime(LocalDateTime.now());

        return data;
    }
    @GetMapping("sub13")
    @ResponseBody
    public Map<String, String> method13() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("address", "seoul");
        map.put("email", "daram@gmail.com");
        map.put("age", "26");
        return map;
    }
    @GetMapping("sub14")
    @ResponseBody
    public Map<String, Object> method14 () {
        Map<String, Object> map = new HashMap<>();
        JavaBean25 data = new JavaBean25();
        JavaBean26 sub = new JavaBean26();

        sub.setAddress(List.of("제주", "울릉도"));
        sub.setMarried(false);

        data.setAge(4);
        data.setInfo(sub);

        map.put("address", "인천");
        map.put("age", 26);
        map.put("married", true);
        map.put("data", data);

        return map;
    }
    @GetMapping("sub15")
    @ResponseBody
    public Map<String, Object> method15() {
        Map<String, Object> map = new HashMap<>();

        map.put("car","tesla");
        map.put("model","avante");
        map.put("color",List.of("blue", "red"));

        return map;
    }
}
