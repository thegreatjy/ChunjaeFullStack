<코딩 자율학습 HTML + CSS + 자바스크립트> 책으로 html, css, js를 공부한 후, 포트폴리오 웹 페이지를 만들었습니다.


https://thegreatjy.github.io/JavaStudy/portfolio/index.html 에서 확인할 수 있습니다.


# 수정사항
# portfolio 페이지

<img width="515" alt="Untitled 2" src="https://github.com/thegreatjy/JavaStudy/assets/74610908/7526aa16-2316-4c68-abd3-c60473cb2fc3">

### \<br>

<p>태그 안에서 줄 바꿈을 해주기 위해 사용하였다.

```html
<h3>
Deploying a Sustainable<br>Deep Learning Pipeline<br>for Poison
Ivy Image Classification
</h3>
```
<br><br><br>

<img width="1034" alt="Untitled 3" src="https://github.com/thegreatjy/JavaStudy/assets/74610908/61e1e156-7d8b-483c-b2b6-720e358281a5">

```html
<div class="portfolio-me">
    <table>
        <tr>
            <td>
                <div class="portfolio-inner">
                    <a href="https://github.com/thegreatjy/DreamHome">
                        <div class="icon">
                          <i class="fa-brands fa-android"></i>
                        </div>
                        <strong>Android Application</strong>
                        <h3>Dream Home</h3>
                    </a>
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

### \<a>

포트폴리오 각 상자 영역을 누르면 관련 웹으로 이동한다

### table

포트폴리오를 보여줄 때, 테이블로 각 요소를 구성하였다.

프로젝트는 총 2개로 1행 2개의 열에 각각 프로젝트를 넣어준다.

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

### flex

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

# 유효성 검사

- html 유효성 검사 : [http://validator.w3.org/](http://validator.w3.org/)

<img width="2124" alt="Untitled 4" src="https://github.com/thegreatjy/JavaStudy/assets/74610908/af01490a-cccb-4659-8eca-bc4ee6a6f6ef">

- CSS 유효성 검사 :  [http://jigsaw.w3.org/css-validator](http://jigsaw.w3.org/css-validator/)

<img width="2196" alt="%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2023-10-22_15 42 15" src="https://github.com/thegreatjy/JavaStudy/assets/74610908/5eb8f048-0f0e-4b12-82c5-fbf1ab2ea2cd">