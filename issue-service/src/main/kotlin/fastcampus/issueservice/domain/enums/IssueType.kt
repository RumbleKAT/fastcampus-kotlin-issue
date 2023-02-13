package fastcampus.issueservice.domain.enums

enum class IssueType {

    BUG, TASK;

    companion object{
        operator fun invoke(type:String) = valueOf(type.uppercase())
    } // 생성자를 사용하는 것처럼 사용할수 있음
}
