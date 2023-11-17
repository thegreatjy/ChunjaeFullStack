package el;

public class MyELClass {
    // 주민번호를 입력받아 성별 반환
    public String getGender(String jumin){
        String returnStr = "";
        int beginIdx = jumin.indexOf("-") + 1; // - 다음 위치 인덱스 리턴
        String genderStr = jumin.substring(beginIdx, beginIdx + 1);
        int genderInt = Integer.parseInt(genderStr);
        if(genderInt == 2 || genderInt == 4){
            returnStr = "여자";
        }else if(genderInt == 1 || genderInt == 3){
            returnStr = "남자";
        }else{
            returnStr = "오류";
        }

        return returnStr;
    }

    // 입력받은 문자열이 숫자인지 판별
    public static boolean isNumber(String value){
        char[] chArr = value.toCharArray();
        for(char c: chArr){
            if(!(c >= '0' && c <= '9')){
                return false;
            }
        }
        return true;
    }

    // 2단~limitDan단 구구단 테이블 출력
    public static String showGugudan(int limitDan){
        StringBuffer sb = new StringBuffer();
        try{
            sb.append("<table border='1'>");
            for(int i=2; i<=limitDan; i++){
                sb.append("<tr>");
                for(int j=1; j<=9; j++){
                    sb.append("<td> "+i+"*"+j+"="+(i*j)+"</td>");
                }
                sb.append("</tr>");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return sb.toString();
    }
}
