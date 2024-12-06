# mukho.gg

[리그 오브 레전드] 마지막 매치에 대한 상세 페이지

## 사용 기술

### BE

- Java 17
- Spring Boot 3.4.0
- Riot Games API

### FE

- Thymeleaf

## 기능

### 소환사명#태그 검색

- Riot Games API를 통한 `소환사명#태그` 검색
- 소환사명#태그 정보가 없거나, 최근 진행한 소환사의 협곡 매치가 없는 경우 예외 처리

### 매치 상세 페이지

#### 정보

- 팀/라인/소환사 별로 챔피언, 룬/특성, 스펠, KDA, CS 등 기본 정보 제공

#### 통계

- 매치 지표에 대한 다양한 그래프 정보 제공
- 매치 시간대별 킬, 타워, 오브젝트 정보와 골드 차이를 보여주는 그래프 제공
  - 어떤 시간대에 매치의 유불리가 가장 크게 변화하였는지 텍스트로 제공

## 프로젝트 구조

```
com.mukho.mukhogg/
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
├── dto/
│   ├── DataDragonUtil.java (이미지 API 호출 Util)
│   └── DataMappingUtil.java (이미지 정보 매핑 Util)
└── resources/
    ├── templates/
    │   └── main.html (메인 페이지 템플릿)
    │   └── components/
    │       ├── header.html (로고 및 검색창 표시 템플릿)
    │       ├── empty-state.html (첫 화면용 템플릿)
    │       ├── match-info.html (매치 정보 표시 템플릿)
    │       ├── team-info.html (팀별 정보 표시 템플릿)
    │       └── match-stats.html (통계 정보 표시 템플릿)
    ├── application.properties
    └── apikey.properties (Riot API 키 설정)
```
