package spring.example.test.repository;

import spring.example.test.domain.SampleData;

import java.util.List;

public interface QueryRepository {

    List<SampleData> getSampleQuery();
}
