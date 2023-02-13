package fastcampus.issueservice.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class) //entity의 이벤트 발생시 콜백
abstract class BaseEntity(
    @CreatedDate //entity가 생성될때 바로 생성함
    var createdAt: LocalDateTime?=null,

    @LastModifiedDate
    var updatedAt: LocalDateTime?=null,
)