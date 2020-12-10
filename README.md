## [인프런] 스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술 실습
***

#### 스프링 웹 개발 기초 - API
*@RequestBody의 사용원리*

클라이언트에서 요청을 받으면 ViewResolver가 아닌 HttpMessgeConventer가 동작함.
 1) 단순 문자인 경우 : SpringHttpMessgeConventer
 2) 객체인 경우 : MappingJackson2HttpMessgeConventer ( default가 json방식)
 3) 기타 여러 처리 있음 (byte 등)
 ** 클라이언트 HTTP Accept해더와 서버의 컨트롤러 반환타입 정보들을 조합해서 'HttpMessgeConventer'가 선택됨
