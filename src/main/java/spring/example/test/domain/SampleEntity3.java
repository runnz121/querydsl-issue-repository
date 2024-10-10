package spring.example.test.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicUpdate
@EqualsAndHashCode(of = {"key"}, callSuper = false)
@Entity
public class SampleEntity3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SAMPLE3_KEY")
    private Long key;
}
