package spring.example.test.domain;

import com.querydsl.core.annotations.QueryProjection;

public record SampleData(

        String status
) {

    @QueryProjection
    public SampleData {

    }
}
