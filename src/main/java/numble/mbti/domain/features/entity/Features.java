package numble.mbti.domain.features.entity;

import numble.mbti.domain.category.entity.Category;
import numble.mbti.domain.features.contstant.FeaturesAttribute;
import numble.mbti.domain.features.contstant.MbtiType;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import numble.mbti.domain.features.converter.FeaturesContentConvert;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Features {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    private String name;

    private Integer grade;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    private MbtiType type;

    @Convert(converter = FeaturesContentConvert.class)
    @Column(length = 2000)
    private FeaturesAttribute Content;
}
