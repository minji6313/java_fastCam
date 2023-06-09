package FastCampus.Java_0606;

//object = 상태정보 (멤버변수) + 행위정보(멤버메서드)
public class Ex_14_PersonDTO {
    private String name;
    private int age;
    private String phone;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    // ↓ 기본 생성자 메서드(default 생성자)
    public Ex_14_PersonDTO() {

    }

    public void play() {
        System.out.println("운동을 한다.");
    }
    public void eat() {
        System.out.println("음식을 먹다.");
    }
    public void walk() {
        System.out.println("걷다.");
    }
}
