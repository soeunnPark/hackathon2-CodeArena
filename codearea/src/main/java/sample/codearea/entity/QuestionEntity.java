package sample.codearea.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import sample.codearea.common.TimeTrackableEntity;

@Entity
@Table(name = "QUESTION")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestionEntity extends TimeTrackableEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "questionId")
	private Long id;

	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
	private UserEntity user;

	@ManyToMany(mappedBy = "questionScraps")
	private List<UserEntity> users = new ArrayList<>();

	@Column(nullable = false, columnDefinition = "VARCHAR(255)")
	private String title;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String content;

	@Column(nullable = false, columnDefinition = "INT")
	@ColumnDefault("0")
	private Integer views = 0;

	@Column(nullable = false, columnDefinition = "INT")
	@ColumnDefault("0")
	private Integer likes = 0;

	@Column(nullable = false, columnDefinition = "INT")
	@ColumnDefault("0")
	private Integer hates = 0;

	@Builder
	protected QuestionEntity(
		Long id,
		UserEntity user,
		String title,
		String content
	) {
		this.id = id;
		this.user = user;
		this.title = title;
		this.content = content;
	}
}