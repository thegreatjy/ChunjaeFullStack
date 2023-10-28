package week3;

import lombok.*;

@RequiredArgsConstructor
public class Member {
    private final static boolean flag = true;
    @   NonNull private boolean editFlag;

    void setEditFlag(boolean b){
        this.editFlag = b;
    }
    

    int num;
    String name, id, phone;
    public static void main(String[] args) {

    }

    /*@Override
    public boolean equals(Object obj) {
        // obj가 Member 타입인지 검사하고 타입 변환 후 target 변수에 대입
        if(obj instanceof Member target){
            if(id.equals(target.id)){
                return true;
            }
        }
        return false;
    }*/
}
