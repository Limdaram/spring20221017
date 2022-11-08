package com.example.spring20221017.domain.board;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.Temporal;

@Data
public class ReplyDto {
    private int id;
    private int boardId;
    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime inserted;

    public String getAgo() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneDayBefore = now.minusDays(1);
        LocalDateTime oneWeekBefore = now.minusWeeks(1);
        LocalDateTime oneMonthBefore = now.minusMonths(1);
        LocalDateTime oneYearBefore = now.minusYears(1);
        // 작성일과 현재가

        // 하루 차이면 시간을 출력
//        if (oneDayBefore.isBefore(inserted)) {
//            result = inserted.toLocalTime().toString();
//        } else if (oneWeekBefore.isBefore(inserted)) {
//            result = Period(inserted.toLocalDate(), now.toLocalDate()).getDays() + "일 전";
//        } else if (oneMonthBefore.isBefore(inserted)) {
//            result = Period(inserted.toLocalDate(), now.toLocalDate()).get(Temporal) + "주 전";
//        }
        // 일주일 이내면 n일 전

        // 한달 이내면 n주 전

        // 1년 이내면 n달 전

        // 그 외는 몇년 전
        return null;
    }
}