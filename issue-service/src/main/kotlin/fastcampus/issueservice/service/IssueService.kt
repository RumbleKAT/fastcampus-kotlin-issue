package fastcampus.issueservice.service

import fastcampus.issueservice.domain.Issue
import fastcampus.issueservice.domain.IssueRepository
import fastcampus.issueservice.model.IssueRequest
import fastcampus.issueservice.model.IssueResponse
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class IssueService(
    private val issueRepository: IssueRepository
) {
    @Transactional
    fun create(userId:Long, request: IssueRequest) : IssueResponse{
        val issue = Issue(
            summary = request.summary,
            description = request.description,
            userId = userId,
            type = request.type,
            priority = request.priority,
            status = request.status,
        )
        return IssueResponse(issueRepository.save(issue))
    }
}