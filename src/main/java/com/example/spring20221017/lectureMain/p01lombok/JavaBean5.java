package com.example.spring20221017.lectureMain.p01lombok;

import lombok.Data;

@Data
// @Data : @ToString, @EqualsAndHashCode, @Getter, @Setter, @RequiredArgsConstructor
// 다섯 개의 어노테이션을 한번에 적용
public class JavaBean5 {
    private String name;
    private int age;
}
