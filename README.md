# fastcampus-kotlin-issue
fastcampus-kotlin-issue

## kotlin 이슈 정리
- spring boot 3.0 이상부터 jarkata.persistence로 이전.. 기존의 java.persistence 보다 좀더 엄격한 체킹으로 2.7로 다운 그레이드함

## Session 기반 인증
- 사용자가 로그인을 하게되면, 사용자 정보 검증 후 세션 ID를 발급하고, 브라우저의 쿠키(JSESSION)에 저장한다.
- 브라우저는 모든 요청마다 쿠키에 있는 세션 ID를 포함하고 서버는 세션 ID를 통해 유저 정보를 세션 스토리지에서 조회한다. 
- 단점으로, 세션클러스터링 구현 및 redis와 같은 세션 데이터베이스가 필요하다.

## Token 기반 인증
- IO 작업을 하지 않아도 됨
- 만료시간을 짧게 가져가야됨 (만료시, 리프레시 토큰을 사용해야한다.)
- 토큰이 길어지면 네트워크 부하가 된다.
- JWT의 경우 단일키를 사용하기 때문에 시크릿키가 유출되면 보안 취약사항이된다.