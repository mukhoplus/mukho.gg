# mukho.gg

[리그 오브 레전드] 마지막 매치에 대한 상세 페이지

## 사용 기술

### BE

- Java 17
- Spring Boot 3.4.0
- Riot Games API

### FE

- HTML
- CSS
- Thymeleaf

## 기능

### 소환사명#태그 검색

- Riot Games API를 통한 `소환사명#태그` 검색
- 소환사명#태그 정보가 없거나, 최근 진행한 소환사의 협곡 매치가 없는 경우 예외 처리

### 매치 상세 페이지

#### 정보

- 팀/라인/소환사 별로 챔피언, 룬/특성, 스펠, KDA, CS, 분당 CS, 획득 골드 등 기본 정보 제공

#### 통계

- 매치 지표에 대한 다양한 그래프 정보 제공
  - 챔피언 딜량, 골드 획득량, CS, 킬, 데스, 어시스트, 와드 설치, 와드 제거, 제어 와드 구매, 레벨
- ~~매치 시간대별 킬, 타워, 오브젝트 정보와 골드 차이를 보여주는 그래프 제공~~
  - ~~어떤 시간대에 매치의 유불리가 가장 크게 변화하였는지 텍스트로 제공~~

## 프로젝트 구조

```
com.mukho.mukhogg/
├── MukhoggApplication.java
├── controller/
│   └── MukhoggController.java (소환사 검색 및 매치 정보 조회 컨트롤러)
├── service/
│   ├── MukhoggService.java (인터페이스)
│   └── impl/
│       └── MukhoggServiceImpl.java (서비스 호출 구현)
├── dto/
│   ├── account/  (소환사 정보 DTO)
│   │   └── AccountDto.java
│   │   └── ...
│   └── matches/
│       ├── match/ (매치 정보 DTO)
│       │   └── MatchDto.java
│       │   └── ...
│       └── timeline/ (타임라인 정보 DTO)
│           └── TimelineDto.java
│           └── ...
├── util/
│   ├── DataDragonUtil.java (이미지 API 호출 Util)
│   └── DataMappingUtil.java (이미지 등 정보 매핑 Util)
└── resources/
    ├── templates/
    │   └── main.html (메인 페이지 템플릿)
    │   └── components/
    │       ├── header.html (로고 및 검색창 표시 템플릿)
    │       ├── empty-state.html (첫 화면용 템플릿)
    │       ├── toogle-tabs.html (토글 템플릿)
    │       ├── match-info.html (매치 정보 표시 템플릿)
    │       ├── team-info.html (팀별 정보 표시 템플릿)
    │       └── match-stats.html (통계 정보 표시 템플릿)
    ├── application.properties
    └── apikey.properties (Riot API 키 설정)
```

## 이미지

### 메인 화면

![메인 화면](https://github.com/user-attachments/assets/114088d4-0002-4c75-9af2-311d497b116c)

### 아이디 형식 오류

![형식 오류](https://github.com/user-attachments/assets/cd10410c-1f4f-4abb-9157-0f49f03df5e2)

### 계정 정보 없음

![계정 정보 없음](https://github.com/user-attachments/assets/3dfe2b97-e819-40ec-bc57-a95376f75943)

### 매치 기록 없음

![매치 기록 없음](https://github.com/user-attachments/assets/849b4712-b94b-468f-ba36-d27f137673de)

### 정보

![정보](https://github.com/user-attachments/assets/a9fc06e9-3da0-4178-af08-6cc043b1274d)

### 정보 - 아이디 ... 및 클릭 검색

![정보-아이디 ... 및 클릭 검색](https://github.com/user-attachments/assets/27b990e4-89fb-4571-93ea-186693e7fac1)

### 통계-1

![통계-1](https://github.com/user-attachments/assets/c421b0e4-357c-4927-aa34-5497ecf797f0)

### 통계-2

![통계-2](https://github.com/user-attachments/assets/22581933-70f8-42ee-8282-abfb9c275225)

### 통계-3

![통계-3](https://github.com/user-attachments/assets/e75a321a-863b-4030-ae75-f7b12d350c09)
