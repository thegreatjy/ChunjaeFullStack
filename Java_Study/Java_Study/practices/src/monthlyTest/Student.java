package monthlyTest;

public class Student {
    String name;
    int age;
    boolean csMajor;
    int score = 0;

    Student() {
        name = "이름입력요망";
        age = 0;
        csMajor = false;
    }

    Student(String name, int age, boolean csMajor){
        this.name = name;
        this.age = age;
        this.csMajor = csMajor;
    }

    // 점수 score 입력
    public void insertScore(int score){
        this.score = score;
    }

    // score를 minus 만큼 차감
    public void subtractScore(int minus){
        this.score -= minus;
    }

    // score 확인
    public int getScore(){
        System.out.print("학생의 점수는 : ");
        return this.score;
    }

    public static void main(String[] args) {
        // 학생 클래스 인스턴스 생성
        Student std1 = new Student("이지연", 26, true);


        // 점수 입력
        std1.insertScore(100);
        // 점수 확인
        System.out.println(std1.getScore());

        // 점수 차감
        std1.subtractScore(39);
        // 점수 확인
        System.out.println(std1.getScore());
    }
}
