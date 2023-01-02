# :dart: 구인 구직 매칭 플랫폼 humancloud 

***"자신에게 맞는 일자리를 찾아드립니다!"*** </br>
들어가는 실업률, 계속되는 구인, 구직에 지치신 당신! </br>
저희 humancloud에서는 회원들에게 적절한 공고 및 이력서를 추천해서 구인, 구직 기간을 줄이고 필요한 공고 및 이력서들에만 집중할 수 있게 만들어드립니다!
</br></br>

## :triangular_flag_on_post: 프로젝트 개요
### 레퍼런스 사이트(사람인, 원티드)
![image](https://user-images.githubusercontent.com/95184357/210056914-00ec8963-1462-4f87-8ee4-eb8af0faa176.png)
![image](https://user-images.githubusercontent.com/95184357/210056897-aa5ea6b9-e5e0-489f-8f54-3ae3fd670455.png)

### 개발 이유
구인, 구직 추천 플랫폼을 통해서 서비스 로직에 대한 이해와 spring기반 MVC 패턴 개발을 익히기 위해서 선택

### 테이블 구성

#### ER다이어그램
![image](https://user-images.githubusercontent.com/95184357/210116111-b34d45ad-87d7-4b9e-a95c-b36e72b7b705.png)

#### DB - user생성 및 권한 부여
```sql
CREATE USER 'human'@'%' IDENTIFIED BY 'human1234';
CREATE database humandb;
GRANT ALL PRIVILEGES ON *.* TO 'human'@'%';
```

#### 테이블 생성 - create 구문
```sql
-- 구직자(유저) 
CREATE TABLE user (
	user_id INT auto_increment PRIMARY KEY,
	username VARCHAR(50) UNIQUE NOT null,
	password VARCHAR(50) NOT null,
	name VARCHAR(50) NOT null,
	email VARCHAR(120) UNIQUE NOT null,
	phone_number VARCHAR(100) UNIQUE,
	created_at TIMESTAMP
) engine=InnoDB default charset=UTF8;

-- 분야
CREATE TABLE category (
	category_id INT auto_increment PRIMARY KEY,
	category_resume_id INT,
	category_recruit_id INT,
	category_name VARCHAR(50)
) engine=InnoDB default charset=UTF8;

-- 회사 
CREATE TABLE company (
	company_id INT auto_increment PRIMARY KEY,
	company_username VARCHAR(50) UNIQUE NOT null,
	company_password VARCHAR(50) NOT null,
	company_name VARCHAR(50) UNIQUE NOT null,
	company_email VARCHAR(120) UNIQUE NOT null,
	company_phone_number VARCHAR(100) UNIQUE,
	company_address VARCHAR(150) NOT null,
	company_logo VARCHAR(500),
	company_created_at TimeStamp
) engine=InnoDB default charset=UTF8;

-- 이력서 
CREATE TABLE resume(
	resume_id INT AUTO_INCREMENT PRIMARY KEY,
	resume_title VARCHAR(50) NOT null,
	resume_photo VARCHAR(500),
	resume_education VARCHAR(50),
	resume_career VARCHAR(50),
	resume_link VARCHAR(500), 
	resume_read_count INT,
	resume_user_id INT,
	resume_created_at TIMESTAMP
) engine=InnoDB default charset=UTF8;


-- 채용 공고 
CREATE TABLE recruit(
	recruit_id int auto_increment PRIMARY KEY,
	recruit_title VARCHAR(50) NOT NULL,
	recruit_career VARCHAR(50),
	recruit_salary INT,
	recruit_location VARCHAR(120),
	recruit_content LONGTEXT,
	recruit_read_count INT,
	recruit_company_id INT,
	recruit_deadline TIMESTAMP,
	recruit_created_at TIMESTAMP
) engine=InnoDB default charset=UTF8;

-- 채용 지원 
CREATE TABLE apply(
	apply_id INT AUTO_INCREMENT PRIMARY KEY,
	apply_recruit_id INT, 
	apply_resume_id INT, 
	apply_created_at TIMESTAMP
) engine=InnoDB default charset=UTF8;

-- 관심 기업 구독
CREATE TABLE subscribe(
	subscribe_id INT auto_increment PRIMARY KEY,
	subscribe_user_id INT,
	subscribe_company_id INT,
	subscribe_created_at TIMESTAMP
) engine=InnoDB default charset=UTF8;
```

### fk 제약조건
```sql
-- 이력서 테이블 fk
ALTER TABLE resume ADD FOREIGN KEY(resume_user_id) REFERENCES user(user_id);

-- 채용 공고 테이블 fk
ALTER TABLE recruit ADD FOREIGN KEY(recruit_company_id) REFERENCES company(company_id);

-- 채용 지원 테이블 fk
ALTER TABLE apply ADD FOREIGN KEY(apply_recruit_id) REFERENCES recruit(recruit_id);
ALTER TABLE apply ADD FOREIGN KEY(apply_resume_id) REFERENCES resume(resume_id);

-- 관심 기업 구독 테이블 fk
ALTER TABLE comment ADD FOREIGN KEY(subscribe_user_id) REFERENCES user(user_id);
ALTER TABLE comment ADD FOREIGN KEY(subscribe_company_id) REFERENCES company(company_id);

```

### utf-8 변경
```sql
alter table user convert to character set utf8;

alter table company convert to character set utf8;

alter table resume convert to character set utf8;

alter table recruit convert to character set utf8;

alter table category convert to character set utf8;

alter table apply convert to character set utf8;

alter table subscribe convert to character set utf8;
```


## :ferris_wheel: 1. 제작 기간 & 팀원 소개
* 2022년 10월 05일 ~ 2022년 10월 19일

| 이름 | 깃허브 링크 |
| ----- | --- |
| 김민철 | Sylar0012(https://github.com/Sylar0012) |
| 장성운 | Goldfish808(https://github.com/Goldfish808) |
| 허유진 | yujin9907(https://github.com/yujin9907) |
| 정수영 | gitthathonor(https://github.com/gitthathonor) |
</br>

> **조원 역할 및 기능 개발 설명**
> 
> 
> > **김민철**
> >
> > - 이력서 관련 페이지 생성
> > - 이력서 CRUD 및 기업에 맞는 이력서 추천 매칭 기능, 공고 지원하기 구현
. > - Multipart를 이용한 이미지 업로드 기능 구현
> > - Redis로 세션 관리 설계
> 
> > **장성운**
> > 
> > - 공고 CRUD 및 페이지 생성
> > - 구직자 입장에서 맞는 기업공고 매칭, 관련 기업 리스트 보기 기능 구현
> > - 더미데이터 작성
> 
> > **허유진**
> > 
> > - 구직자 CRUD 및 페이지 생성
> > - 마이페이지 관련 DTO 설계
> > - 관심 기업 구독 및 취소 기능 구현
> > - 웹소켓으로 알림기능 구현
> > - 각종 추천 알고리즘 및 정렬과 페이징 처리 구현
> 
> > **정수영**
> > 
> > - 백엔드 서버 세팅
> > - 기업회원 관련 페이지 생성
> > - 기업 CRUD 기능 및 각종 유효성 체크 구현
> > - 테이블 구성
> > - 카카오 주소 및 지도 API 사용해서 기능 구현

<br/>

## :triangular_ruler: 2. 화면 설계
[humancloud 화면설계](https://www.figma.com/file/qNC1LJR8I5G3b5o3rzLwLo/humancloud?node-id=0%3A1)
</br></br>

## :video_camera: 3. 시연영상
[humancloud 시연영상](https://www.youtube.com/watch?v=YQcnzzxjVC0)
</br></br>

## :bulb: 4. 사용자 시나리오

### 구직자 입장
- 채용공고 확인
![image](https://user-images.githubusercontent.com/95184357/210122884-e465ba50-8857-40bb-bb79-7707051ac49a.png)

- 이력서 작성
![image](https://user-images.githubusercontent.com/95184357/210122890-e67a7c41-d847-461d-ace9-028094231d75.png)

- 채용 지원
![image](https://user-images.githubusercontent.com/95184357/210122897-65b66b8c-55a6-45c6-92b2-5632e21e523e.png)

- 관심기업 구독
![image](https://user-images.githubusercontent.com/95184357/210122912-cdf4e9b8-cccf-4b31-b75b-8d8f13db9d05.png)

- 마이페이지 내 인기순으로 기업목록 보여주기
![image](https://user-images.githubusercontent.com/95184357/210122919-9c2c4d36-f721-466c-b041-d69b5155c186.png)

### 기업 입장

- 채용 공고 작성
![image](https://user-images.githubusercontent.com/95184357/210122925-1622000c-faaf-42fa-9d89-015d9fd7995a.png)

- 추천하는 이력서 매칭
![image](https://user-images.githubusercontent.com/95184357/210122929-d237905a-e172-4e64-b7a2-a301f8a1f429.png)

- 구독 및 공고 지원 확인
![image](https://user-images.githubusercontent.com/95184357/210122934-00b2c6e4-7b74-417f-b33c-dd1dd01460a2.png)
</br></br>


## :wrench: 5. 개발 환경
![image](https://user-images.githubusercontent.com/95184357/210122208-c6bb8f96-922c-4155-9114-5be06f1c8db8.png)

## :pushpin: 6. 주요 코드

### 주소 및 지도 API
- 주소 API
```java
// 주소 API
function sample6_execDaumPostcode() {
	new daum.Postcode({
		oncomplete: function (data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
			// 각 주소의 노출 규칙에 따라 주소를 조합한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var addr = ''; // 주소 변수
			var extraAddr = ''; // 참고항목 변수
			//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
				addr = data.roadAddress;
			} else { // 사용자가 지번 주소를 선택했을 경우(J)
				addr = data.jibunAddress;
			}
			// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
			if (data.userSelectedType === 'R') {
			// 법정동명이 있을 경우 추가한다. (법정리는 제외)
			// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
			if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
				extraAddr += data.bname;
			}
			// 건물명이 있고, 공동주택일 경우 추가한다.
			if (data.buildingName !== '' && data.apartment === 'Y') {
				extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
			}
			// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
			if (extraAddr !== '') {
				extraAddr = ' (' + extraAddr + ')';
			}
			// 조합된 참고항목을 해당 필드에 넣는다.
			document.getElementById("companyAddress").value = addr + extraAddr;

			} else {
				document.getElementById("companyAddress").value = '';
			}
		}
	}).open();
}
```
- 지도 API
```java
// 지도 API
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	mapOption = {
		center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		level: 3 // 지도의 확대 레벨
	};

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption);

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch(address, function (result, status) {

	// 정상적으로 검색이 완료됐으면 
	if (status === kakao.maps.services.Status.OK) {

		var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

		// 결과값으로 받은 위치를 마커로 표시합니다
		var marker = new kakao.maps.Marker({
			map: map,
			position: coords
		});

		// 인포윈도우로 장소에 대한 설명을 표시합니다
		var infowindow = new kakao.maps.InfoWindow({
			content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
		});
		infowindow.open(map, marker);

		// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		map.setCenter(coords);
	}
}); 
```

### 추천순 공고 정렬
```sql
select recruit.*, result.count from recruit
left join
(select *, count(*) count
from
(select c2.* from (select category.*
from
(select resume.* from resume inner join user
on user.user_id=resume.resume_user_id
where user_id=#{userId}) r
inner join category
on r.resume_id=category.category_resume_id
group by category_name) c1
join (SELECT * FROM category
WHERE category_recruit_id is not null) c2
on c1.category_name=c2.category_name) list
group by category_recruit_id) result
on recruit.recruit_id=result.category_recruit_id
order by count DESC
```

### Redis 세팅
```java
package site.metacoding.humancloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@PropertySource(value = "application.properties")
@Configuration
@EnableRedisRepositories
public class MyRedisConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory(host, port);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        return redisTemplate;
    }
}
```

### 웹소켓
- 웹소켓 Config 파일로 메세지 매핑을 
```java
package site.metacoding.humancloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@EnableWebSocketMessageBroker
@Configuration
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // 어떤 구직자가 구독하는지 정함
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/websocket")
                .addInterceptors(new HttpSessionHandshakeInterceptor())
                .withSockJS();
    }

    // 어떤 구직자나 기업한테 메시지를 반환할지
    // 메시지메핑하는 프리픽스 설정할게
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/sub");
        registry.setApplicationDestinationPrefixes("/pub");
    }
}
```

- stomp.js 코드로 어떤 이벤트가 발생할 때, 알림창에 보내줄 메세지 설정
```js
let receiverUser = $("#checkUser").val();
let receiverUserId = $("#checkUserId").val();
let receiverCompany = $("#checkCompany").val();
let receiverCompanyId = $("#checkCompanyId").val();

let stomp="";

window.onload=function (){
    if(receiverUser != null){
        let socket = new SockJS('/websocket');
        stomp = Stomp.over(socket);
        stomp.connect({}, function () {
            console.log('연결됨');
            stomp.subscribe('/sub/addRecruit/'+receiverUserId, function (result){
                let parsingResult = JSON.parse(result.body);
                console.log(parsingResult);
                $("#boxAlarm").empty();
                $("#boxAlarm").append(viewMessage(parsingResult));
                $("#notificationDropdown").dropdown('show');
            });
        });
    } else if (receiverCompany != null) {
        let companySocket = new SockJS('/websocket');
        stomp = Stomp.over(companySocket);
        stomp.connect({}, function () {
            console.log('연결됨');
            stomp.subscribe('/sub/alarm/'+receiverCompany, function (result){
                let parsingResult = JSON.parse(result.body);
                console.log(parsingResult);
                $("#boxAlarm").empty();
                $("#boxAlarm").append(viewMessage(parsingResult));
                $("#notificationDropdown").dropdown('show');
            });
        });
    }
}

function viewMessage(message){
    let sender =  message.sender;
    let alarmType = message.alarmType;

    // message = message.replaceAll("\n", "<br>").replaceAll(" ", "&nbsp");

    let resultMessage =`<div class="preview-item-content">`+sender+` 님이 `+alarmType+`하였습니다</div>`;
    return resultMessage
}
// topbar---------------------------------------------------------------------


function sendData(){
    let writer = $("#writer").val();
    let data = {
        'receiverUsername': writer,
        'alarmType':'구독',
        'sender':receiverUser,
    };

    stomp.send("/pub/alarm", {}, JSON.stringify(data));
}
// company detail-----------------------------------------------------------------

function sendRecruitAlarm(){
    let data = {
        'senderId' : receiverCompanyId,
        'sender':receiverCompany,
        'alarmType':'채용공고 작성',
    }

    stomp.send("/pub/createRecruit", {}, JSON.stringify(data));
}

//recruit saveform----------------------------------------------------------------
```

## :bomb: 7. trouble shooting 

### github issues
![Untitled](https://user-images.githubusercontent.com/95184357/210123546-c298d19b-71df-47ac-8d34-1de09ddc9715.png)

### recruit-detail 수정사항 메모
PathVarilable 이 해당 프로젝트에서는 동작하지않아, 쿼리스트릥으로
Get 요청을 받아  findById 메서드 실행을 한 후,
jstl 로 view 페이지에 로드 했음

layout/header.jsp 에서 충돌나는 헤드 코드 saveForm 에서만 쓰일 수 있도록 코드 옮김. 이 전의 코드를 참고.

### 부트스트랩 로드 오류
부트스트랩 Font 로드 오류가 있어 수정함
![Untitled](https://user-images.githubusercontent.com/92712092/194812543-6bf839a5-8397-4b4b-9dba-ac9d8f75e191.png)

### 테이블에 컬럼 추가 for MariaDB(해결됨)
```sql
ALTER TABLE recruit ADD COLUMN recruit_deadline VARCHAR(20) AFTER recruit_company_id;
```

## :gift: 8. 전체적인 소감
- 좋았던 점
1. 팀원들이 적극적으로 의견을 피력하면서 혼자서는 그냥 넘어갔을 부분도 다시 체크할 수 있었다.
2. 각 팀원들이 전부 프론트와 백엔드 작업을 다 맡으면서 풀스택에 대한 이해도가 높아졌다.
3. 새로운 기능 및 기술들을 스스로 습득해서 사용한 것이 좋았다.
4. 성취감 고양

- 아쉬웠던 점
1. 기능 구현에 급급하다보니 보안에 가장 중요한 유효성체크를 소홀히 했다.
2. 테이블 설계가 부족 -> 코드 컨벤셔에서 문제가 발생
3. 코드 리팩토링을 할 시간이 부족해서 제대로 하지 못한 점
