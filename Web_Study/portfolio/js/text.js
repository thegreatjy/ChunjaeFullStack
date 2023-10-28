
/* text.js */
// span 요소 노드 가져오기
const spanEl = document.querySelector("main h2 span");
// 화면에 표시할 문장 배열
const txtArr = ["Back-End Developer"];
// 배열의 인덱스 초깃값
let index = 0;
// 화면에 표시할 문장 배열에서 요소를 하나 가져온 뒤, 배열로 만들기
let currentTxt = txtArr[index].split("");

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

function deleteTxt() {
  // 배열에서 마지막 문자를 삭제
  currentTxt.pop();
  // span에 마지막 문자가 삭제된 배열을 업데이트
  spanEl.textContent = currentTxt.join("");

  // 현재 배열에 남은 문자가 있으면 일정 시간 후, deleteTxt 함수를 다시 실행
  if (currentTxt.length !== 0) {
    setTimeout(deleteTxt, Math.floor(Math.random() * 100));
  } else {  // 현재 배열에 남은 문자가 없으면, txtArr 다음 요소를 가져온다. 그 요소로 writeTxt()를 실행한다.
    index = (index + 1) % txtArr.length;
    currentTxt = txtArr[index].split("");
    writeTxt();
  }
}

writeTxt();
/* End text.js */
