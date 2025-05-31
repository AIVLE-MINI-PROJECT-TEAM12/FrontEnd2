# BackEnd
KT AIVLE Team12 BackEnd Team

📚 도서관리서비스

React + Vite + MUI 프런트엔드와 Spring Boot 백엔드로 구현한 **도서 관리 서비스**  
- CRUD·표지 생성(OpenAI DALL·E)·MUI 컴포넌트·Axios API 통신  
- “📝 notepad” 스타일 카드 위에 표지 이미지를 오버레이 하는 UI

<!-- ![screenshot](./docs/screenshot-list.png) -->

---

## 🚀 Features
| 페이지 | 소스코드 링크 | 주요 기능 |
|--------|------|-----------|
| 📗 **Book Entity Class** | [소스](https://github.com/AIVLE-MINI-PROJECT-TEAM12/BackEnd/blob/main/BookManageMent/src/main/java/com/bookmanage/BookManageMent/domain/Book.java) | Book Entity 정의 |
| 📘 **BookRepository Interface** | [소스](https://github.com/AIVLE-MINI-PROJECT-TEAM12/BackEnd/blob/main/BookManageMent/src/main/java/com/bookmanage/BookManageMent/repository/BookRepository.java) | JPA 상속받은 BookRepository 인터페이스 |
| ✏️ **BookService Interface** | [소스](https://github.com/AIVLE-MINI-PROJECT-TEAM12/BackEnd/blob/main/BookManageMent/src/main/java/com/bookmanage/BookManageMent/service/BookService.java) | BookService 인터페이스 |
| 🖼 **BookServiceImpl Class** | [소스](https://github.com/AIVLE-MINI-PROJECT-TEAM12/BackEnd/blob/main/BookManageMent/src/main/java/com/bookmanage/BookManageMent/service/BookServiceImpl.java) | BookService 상속받아 구현 |
| ⚡️ **BookController** | [소스](https://github.com/AIVLE-MINI-PROJECT-TEAM12/BackEnd/blob/main/BookManageMent/src/main/java/com/bookmanage/BookManageMent/controller/BookController.java) | CRUD에 따른 요청 처리 |
| ⚡️ **Book DTO Class** | [소스](https://github.com/AIVLE-MINI-PROJECT-TEAM12/BackEnd/blob/main/BookManageMent/src/main/java/com/bookmanage/BookManageMent/dto/BookDTO.java) | Book DTO 정의 |

---

## 🏗 Tech Stack
| 영역 | 사용 기술 |
|------|----------|
| Frontend | **React 18**, **Vite**, **MUI v5**, Axios, React Router v6 |
| Backend | **Spring Boot 3**, Spring MVC, Spring Data JPA, H2 |
| AI | **OpenAI Images API (DALL·E 3)** |
| Infra | Node >= 18, Java 17, (Option) Docker Compose |

---

## 📂 프로젝트 구조 (backend)
```
src/
└── main/java/com/bookmanage/BookManageMent/
    ├── controller/
    │   ├── BookController.java
    │   └── LoginController.java
    ├── domain/
    │   ├── Book.java
    │   └── User.java
    ├── dto/
    │   ├── BookDTO.java
    │   └── UserDTO.java
    ├── repository/
    │   ├── BookRepository.java
    │   └── UserRepository.java
    ├── service/
    │   ├── BookService.java
    │   └── BookServiceImpl.java
    ├── util/
    │   └── JwtUtil.java
    └── BookManageMentApplication.java
```

![스크린샷 2025-05-30 160751](https://github.com/user-attachments/assets/eedd660e-e86d-48b1-b1eb-a369fc136d9a)


## 📚 Book Management API 사용 가이드 (Postman 기반)
✅ 1. 로그인 (POST /auth/login)
- 요청 Body
  ```
  {
  "user_id": "userid03",
  "user_name": "aivle03"
  }
  ```
- 응답
  ```
  {
  "token": "uuid-토큰",
  }
  ```
![스크린샷 2025-05-30 155334](https://github.com/user-attachments/assets/2a2b7534-870a-454f-948c-4e3cf30d6d2a)

📘 2. 도서 등록 (POST /books)
- /books 으로 도서 등록
- book_id 가 2인 도서
- 요청 Body
  ```
  {
  "book_name": "자바의 정석",
  "summary": "자바 언어의 기본부터 객체지향, 예외 처리까지 상세하게 다룬 프로그래밍 입문서입니다."
  }
  ```
![스크린샷 2025-05-30 160739](https://github.com/user-attachments/assets/671aeb92-d75c-4a97-8d56-5f6edbe55930)
- /books 으로 도서 등록
- book_id 가 3인 도서
![스크린샷 2025-05-30 160815](https://github.com/user-attachments/assets/07f7cb90-487d-4f46-a712-b4ca9c49056a)

📘 3. 도서 목록 조회 (GET /books)
- /books/2 으로 book_id가 2번인 도서 조회
- 조회 결과
![스크린샷 2025-05-30 160751](https://github.com/user-attachments/assets/eb00e908-1071-4bc1-b4a5-58a271cdd27c)

- /books 으로 전체 도서 목록 조회
- 조회 결과
![스크린샷 2025-05-30 160832](https://github.com/user-attachments/assets/044374c3-8855-47cf-bce2-8e8cd0d056ab)

📘 4. 도서 삭제 (DELETE /books/{book_id})
- /books/2 으로 book_id가 2번인 도서 삭제
![스크린샷 2025-05-30 160848](https://github.com/user-attachments/assets/73c0c0d9-c088-4541-905e-c75d2e41a6a9)
![스크린샷 2025-05-30 160903](https://github.com/user-attachments/assets/1daca781-f786-44bc-8884-edc664023e08)


📘 5. 도서 수정 (PUT /books/{book_id})
- /books/3 으로 book_id가 3번인 도서 제목, 본문 수정
- 요청 Body
  ```
  {
  "book_name": "스프링 부트 마스터 수정하기",
  "summary": "Spring Boot 기반 웹 애플리케이션 개발에 필요한 실무 노하우를 정리한 가이드 수정합니다."
  }
  ```
![스크린샷 2025-05-30 160937](https://github.com/user-attachments/assets/e760b750-a0eb-4ab7-86d0-6a40b9a92971)


📘 6. 도서 표지 생성 (PUT /books/{book_id}/cover)
- /books/3 으로 book_id가 3번인 도서 표지 생성
- 요청 Body
  ```
  {
    "book_image": "http://nmixx.pmg"
  }
  ```
![image](https://github.com/user-attachments/assets/5c22b622-df83-4599-80f1-5d1a9774b5fa)

