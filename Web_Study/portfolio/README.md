# Portfolio Web Page
<코딩 자율학습 HTML + CSS + 자바스크립트> 책으로 html, css, js를 공부한 후, 포트폴리오 웹 페이지를 만들었습니다.


<a href="https://thegreatjy.github.io/JavaStudy/Web_Study/portfolio/index.html" target="_blank">Here!</a>
에서 확인할 수 있습니다.

## 목차
  * [Development Environment](#development-environment)
  * [Description](#description)
    + [Main](#main)
    + [Header](#header)
    + [About](#about)
    + [Features](#features)
    + [Portfolio](#portfolio)
    + [Contact](#contact)
  * [수정사항](#수정사항)
    + [portfolio 페이지 - 프로젝트 박스](#portfolio-페이지---프로젝트-박스)
    + [portfolio 페이지 - 프로젝트](#portfolio-페이지---프로젝트)
    + [table](#table)
  * [유효성 검사](#유효성-검사)

<br>

## Development Environment
- VSCode
- HTML5
- CSS3
- JS
- BootStrap

## Description
### Main
![main](https://github.com/thegreatjy/JavaStudy/assets/74610908/c354cf45-6711-46e4-9aa4-f1cbf200dc1e)
흰색 바 | 를 시간에 따라 투명도를 조절하여 커서가 깜빡이는 효과를 주었다.
반응형 웹으로 사용자 화면 크기에 따라 요소 크기를 변경해 주었다.

<br>

### Header
![header1](https://github.com/thegreatjy/JavaStudy/assets/74610908/7f692bc0-95bc-4fa1-9af2-f76e9f20f593)
Main, About, Features, Portfolio, Contact 버튼을 누르면 해당 부분으로 이동하여 바로 확인할 수 있다.
![header2](https://github.com/thegreatjy/JavaStudy/assets/74610908/165ab769-d9d4-45de-9f1f-8af978e059ba)
스크롤을 내리면 분홍색으로 변경된다.

<br>

### About
![about](https://github.com/thegreatjy/JavaStudy/assets/74610908/f198dde6-4683-4fa7-bb87-50e47683029a)
div를 통해 왼쪽에는 사진, 오른쪽에는 자기 소개를 보여준다. 오른쪽 하단 아이콘에는 하이퍼링크를 설정하여 SNS를 연결하였다.

<br>

### Features
![features](https://github.com/thegreatjy/JavaStudy/assets/74610908/8b9f28cf-cab0-49aa-b65d-bd5536621ea1)
주언어, 프레임워크를 보여준다. 박스에 마우스를 올리면 흰색에서 분홍색으로 색이 변경된다.

<br>

### Portfolio
![portfolio](https://github.com/thegreatjy/JavaStudy/assets/74610908/2c7e7ab0-7858-4ed6-b7dd-90aa5afc209c)
프로젝트를 보여준다. 테이블로 각 프로젝트를 보여주었으며, 각 프로젝트는 flex 구조로 1차원 정렬이 되어있다.
하이퍼링크를 통하여 관련 페이지로 이동한다.

<br>

### Contact
![contact](https://github.com/thegreatjy/JavaStudy/assets/74610908/9b1c90d6-9789-4273-b3aa-74686f6b6e6c)
form을 사용하여 화면을 구성하였다. 각 폼이 활성화되면 테두리 색을 분홍색으로 변경하고 그림자 효과를 준다.


<br>

## 수정사항
수업 시간에 배웠던 flex, table을 사용하여 웹 페이지 구조를 수정하였습니다.
### portfolio 페이지 - 프로젝트 박스

<img width="400" alt="Untitled 2" src="https://github.com/thegreatjy/JavaStudy/assets/74610908/7526aa16-2316-4c68-abd3-c60473cb2fc3">

#### <a>
```html
<div class="portfolio-inner">
  <a href="https://github.com/thegreatjy" target="_blank">
    <div class="icon">
      <i class="fa-brands fa-android"></i>
    </div>
    <strong>Android Application</strong>
    <h3>Dream Home</h3>
  </a>
</div>
```

포트폴리오 각 상자 영역을 누르면 관련 웹으로 이동한다.
<br>

#### flex

```css
section.portfolio .portfolio-inner{
  display: flex;
  flex-direction: column;
  position:relative;
  height:inherit;
  padding:1rem 1rem 1rem 1rem;
}
```

테이블 내부의 각 요소(열)의 내부 구성 방식을 flex로 설정하였다.

- flex-direction: column; : 아이콘, 프로젝트 유형, 프로젝트 제목을 세로로 나열하였다.

<br>

### portfolio 페이지 - 프로젝트

<img width="800" alt="Untitled 3" src="https://github.com/thegreatjy/JavaStudy/assets/74610908/61e1e156-7d8b-483c-b2b6-720e358281a5">

### table
```html
<div class="portfolio-me">
    <table>
        <tr>
            <td>
                <div class="portfolio-inner">
                    ...
                </div>
            </td>
            <td>
                <div class="portfolio-inner">
                    ...
                </div>
            </td>
        </tr>
    </table>
</div>
```
테이블을 통해 프로젝트 페이지를 구성하였다.

프로젝트는 총 2개로 1행 2개의 열에 각 프로젝트를 넣어준다.

```css
/* 테이블 요소 간격 설정 */
.portfolio-me table{
  border-spacing: 20px 0px;
}
```
- border-spacing: 각 테이블 요소 간 세로 가로 간격을 조정해주었다. 지금은 1행이라 가로 간격을 0px으로 하였다.

```css
section.portfolio td {
  width: 50%;
  height:fit-content;
}
```

- width: 50%; : 테이블의 각 열의 너비를 50%으로 설정하여 한 행에 두 개의 요소가 들어갈 수 있도록 하였다.

- height: fit-content; : 높이는 테이블 내부 요소의 글자 개수에 따라 늘어날 수 있도록 fit-content 으로 지정하였다.


## 유효성 검사

- html 유효성 검사 : [http://validator.w3.org/](http://validator.w3.org/)

<img width="2124" alt="Untitled 4" src="https://github.com/thegreatjy/JavaStudy/assets/74610908/af01490a-cccb-4659-8eca-bc4ee6a6f6ef">

- CSS 유효성 검사 :  [http://jigsaw.w3.org/css-validator](http://jigsaw.w3.org/css-validator/)

<img width="2196" alt="%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2023-10-22_15 42 15" src="https://github.com/thegreatjy/JavaStudy/assets/74610908/5eb8f048-0f0e-4b12-82c5-fbf1ab2ea2cd">
