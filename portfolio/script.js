/* text_iife.js */
// 텍스트 작성과 삭제 즉시 실행 함수
(function () {
  // span 요소 노드 가져오기
  const spanEl = document.querySelector("main h2 span");
  // 화면에 표시할 문장 배열
  const txtArr = ["Back-End Developer"];
  // txtArr 배열의 인덱스 초깃값
  let index = 0;
  // 화면에 표시할 문장 배열에서 요소를 하나 가져온 뒤, 배열로 만들기
  let currentTxt = txtArr[index].split("");

  // 문자 한 개씩 출력
  function writeTxt() {
    // 배열의 맨 첫 번째 글자를 span에 넣고 배열에서 삭제
    spanEl.textContent += currentTxt.shift();

    // 배열에 남은 문자가 있으면 일정 시간 뒤에 writeTxt 함수를 다시 실행
    if (currentTxt.length !== 0) {
      setTimeout(writeTxt, Math.floor(Math.random() * 100));
    } else {
      // 배열에 남은 문자가 없으면 span에 추가된 문자로 deleteTxt 함수를 실행
      currentTxt = spanEl.textContent.split("");
      setTimeout(deleteTxt, 3000);
    }
  }

  // 문자 한 개씩 삭제
  function deleteTxt() {
    // 배열에서 마지막 문자를 삭제
    currentTxt.pop();
    // span에 마지막 문자가 삭제된 배열을 업데이트
    spanEl.textContent = currentTxt.join("");

    // 현재 배열에 남은 문자가 있으면 일정 시간 후, deleteTxt 함수를 다시 실행
    if (currentTxt.length !== 0) {
      setTimeout(deleteTxt, Math.floor(Math.random() * 100));
    } else {
      // 현재 배열에 남은 문자가 없으면, txtArr 다음 요소를 가져온다. 그 요소로 writeTxt()를 실행한다.
      index = (index + 1) % txtArr.length;
      currentTxt = txtArr[index].split("");
      writeTxt();
    }
  }
  writeTxt();
})();
/* end of text_iife.js */

/* scroll.js */
/* 수직 스크롤이 발생하면 header 태그에 active 클래스 추가 및 삭제 */
const headerEl = document.querySelector("header");
window.addEventListener("scroll", function () {
  requestAnimationFrame(scrollCheck);
});
function scrollCheck() {
  let browerScrollY = window.scrollY ? window.scrollY : window.pageYOffset;
  if (browerScrollY > 0) {
    headerEl.classList.add("active");
  } else {
    headerEl.classList.remove("active");
  }
}
/* end of scroll.js */

/* move.js */
/* 애니메이션 스크롤 이동 */
const animationMove = function (selector) {
  // ① selector 매개변수로 이동할 대상 요소 노드 가져오기
  const targetEl = document.querySelector(selector);
  // ② 현재 웹 브라우저의 스크롤 정보(y 값)
  const browserScrollY = window.pageYOffset;
  // ③ 이동할 대상의 위치(y 값)
  const targetScorllY = targetEl.getBoundingClientRect().top + browserScrollY;
  // ④ 스크롤 이동
  window.scrollTo({ top: targetScorllY, behavior: "smooth" });
};

// 스크롤 이벤트 연결하기
const scollMoveEl = document.querySelectorAll("[data-animation-scroll='true']"); 
for(let i = 0; i < scollMoveEl.length; i++){
  scollMoveEl[i].addEventListener('click', function(e){
    const target = this.dataset.target;
    animationMove(target);
  });
}
/* end of move.js */
