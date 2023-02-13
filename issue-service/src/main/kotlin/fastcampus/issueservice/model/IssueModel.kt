package fastcampus.issueservice.model

import com.fasterxml.jackson.annotation.JsonFormat
import fastcampus.issueservice.domain.Issue
import fastcampus.issueservice.domain.enums.IssuePriority
import fastcampus.issueservice.domain.enums.IssueStatus
import fastcampus.issueservice.domain.enums.IssueType
import org.springframework.data.annotation.CreatedDate
import java.time.LocalDateTime

data class IssueRequest(
    val summary: String,
    val description: String,
    val type: IssueType,
    val priority: IssuePriority,
    val status: IssueStatus,
)

data class IssueResponse(
    val id:Long,
    val summary: String,
    val description: String,
    val type: IssueType,
    val priority: IssuePriority,
    val status: IssueStatus,
    val userId: Long,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val createdAt: LocalDateTime?,
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val updatedAt: LocalDateTime?,
){
    companion object{
        operator fun invoke(issue:Issue) = with(issue){
            // with를 사용하면 this가 issue가 된다.
            IssueResponse(
                id = id!!,
                summary = summary,
                description = description,
                userId = userId,
                type = type,
                priority = priority,
                status = status,
                createdAt = createdAt,
                updatedAt = updatedAt,
            )
        }
    }
}