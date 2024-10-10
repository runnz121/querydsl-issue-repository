package spring.example.test.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SampleStatus {

    SOLD_OUT("SOLD_OUT", "soldeout"),

    SALE("SALE", "sale")
    ;

    private final String code;
    private final String desc;
}
