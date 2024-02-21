# SuiteCare v.2
# Rest API 연동 규격서<br>[{server_address}}]
## 개요
- Project Name : SuiteCare
- Project Manager : 유맑음
- Version Number : V2.05
- Written Date : 2023.02.20
- Update by : 박도진
- Update comment : API 연동 규격서 문서화 작업
---
## 목차
1. [회원관리](#1-회원관리)
    1. [회원가입(POST)](#1-1-회원가입)
    2. [로그인(POST)](#1-2-로그인)
    3. [로그아웃()](#1-3-로그아웃)
    4. [중복회원확인(GET)](#1-4-중복회원확인) 
2. [회원정보](#2-회원정보)
    1. [마이페이지-single_data](#2-1-마이페이지-단일건수조회)

---
<br>

## 1. 회원관리
### 1-1. 회원가입
#### - HTTP Request : POST
- Controller = auth-controller
- HTTP URL = '/api/v1/signup
- Parameter Type

>| 파라미터명 | 타입   | 필수여부 | 설명       |
>|----------|--------|---------|-----------|
>| id       | String | 필수    | 아이디     |
>| password | String | 필수    | 비밀번호   |
>| name     | String | 필수    | 이름      |
>| tel      | String | 필수    | 연락처     |
>| role     | String | 필수    | 회원 타입  |

- Header Type Parameter

>|파라미터명|값|설명|
>|-|-|-|
>|Content-Type|application/json|JSON|
<br>

#### - Response Format : JSON
- Response Type
>
>|엘리먼트명|depth|설명|값구분|
>|-|-|-|-|
>|token|1|해당 유저의 token값|200 : OK<br>400 : Bad Request|

- 샘플 JSON 예제
```json
// 200 ok
1

// 400 bad request
(empty)

```
---

### 1-2. 로그인
#### - HTTP Request : POST
- HTTP URL = '/api/v1/login
- Parameter Type

>| 파라미터명    | 타입     |필수여부| 설명    |
>|----------|--------|-|-------|
>| id       | String    |필수| 아이디   |
>| password | String    |필수| 비밀번호  |
>| role     | String |필수| 회원 타입 |

- Header Type Parameter

>|파라미터명|값|설명|
>|-|-|-|
>|Content-Type|application/json|JSON 통신|
<br>

#### - Response Format : JSON
- Response Type
>
>|엘리먼트명|depth|설명|값구분|
>|-|-|-|-|
> |id|1|아이디||
> |role|1|회원 타입||
> |token|1|JWT Token||

- 샘플 JSON 예제
```json
// 200 ok (로그인 성공)
{
  "id": "Kim123",
  "role": "F",
  "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJLaW0xMjMiLCJyb2xlIjoiRiIsImlhdCI6MTcwODQxMTgzMCwiZXhwIjoxNzA4NDE1NDMwfQ.O9oHLY6Z0QMenGFOXmpiFZ3XB42StzWWfJwm1yCqbOY"
}

// 200 ok (로그인 실패)
(empty)

```
---
### 1-3. 로그아웃
#### - HTTP Request : GET
- HTTP URL = '/api/v1/logout
- Parameter Type

>| 파라미터명    | 타입     |필수여부| 설명    |
>|----------|--------|-|-------|

- Header Type Parameter

>|파라미터명|값|설명|
>|-|-|-|
>|Content-Type|application/json|JSON 통신|
<br>

#### - Response Format : JSON
- Response Type
>
>|엘리먼트명|depth|설명|값구분|
>|-|-|-|-|


- 샘플 JSON 예제
```json
```

---
### 1-4. 중복회원확인
#### - HTTP Request : GET
- HTTP URL = '/api/v1/check/id
- Parameter Type

>| 파라미터명    | 타입     |필수여부| 설명    |
>|----------|--------|-|-------|
> |id|String|필수|아이디|

- Header Type Parameter

>|파라미터명|값|설명|
>|-|-|-|
>|Content-Type|application/json|JSON 통신|
<br>

#### - Response Format : Integer
- Response Type
>
>|엘리먼트명|depth|설명|값구분|
>|-|-|-|-|
> |-|1|동일한 아이디의 회원 count| 1: 아이디 중복 <br> 0: 아이디 사용가능|

- 샘플 JSON 예제
```json
// 200 ok (중복회원 있는 경우)
1

// 200 ok (중복회원 없는 경우)
0

```
---
## 2. 회원정보
### 2-1. 마이페이지 조회
#### - HTTP Request : GET
- Controller = member-controller
- HTTP URL = '/api/v1/mypage
- Authorization = JWT token 요구
- Parameter Type

>| 파라미터명 | 타입   | 필수여부 | 설명       |
>|----------|--------|---------|-----------|
> |파라미터 없음|

- Header Type Parameter

>|파라미터명|값|설명|
>|-|-|-|
>|Content-Type|application/json|JSON|
<br>

#### - Response Format : JSON
- Response Type
>
>| 엘리먼트명 |depth| 설명  | 값구분                                 |
>|-------|-|-----|-------------------------------------|
>| id    |1| 아이디 | 200 : OK<br>403 : forbidden (인증 실패) |
> |name|1|이름||
> |gender|1|성별||
> |birthday|1|생년월일||
> |tel|1|전화번호||

- 샘플 JSON 예제
```json
// 200 ok
{
   "id": "Kim123",
   "name": "김현식",
   "gender": "M",
   "birthday": "2012-02-20",
   "tel": "01048525888"
}

// 403 forbidden
(empty)

```

---