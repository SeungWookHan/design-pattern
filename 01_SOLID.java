// 해당 코드는 Run하기 위해 작성한 코드가 아닌 공부용으로 작성한 것임을 알립니다.

/*
S = SRP, 단일 책임 원칙
O = OCP, 개방/폐쇄 원칙
L = LSP, 리스코프 치환 원칙
I = ISP, 인터페이스 분리 원칙
D = DIP, 의존성 역전 원칙
*/

/*
Single Responsiblity Principle (단일 책임 원칙)
- 소프트웨어의 클래스, 함수 등은 하나의 책임만을 가져야 한다.
- 응집도는 높고, 결합도는 낮은 프로그램
- 한 클래스 또는 함수가 수행할 수 있는 기능, 즉 책임이 많아지면 유지보수에 어려움이 생긴다.
*/

/*
Open-Closed Principle (개방/폐쇄 원칙)
- 기존의 코드를 변경하지 않되(Closed), 기능을 수정하거나 추가하는 것에는 열려(Open) 있어야 한다.
- 변경되는 것이 무엇인지에 초점!
- 자주 변경되는 내용은 수정하기 쉽게, 그렇지 않은 것은 수정되는 내용에 영향 받지 않게 설계
- 이때 자주 사용하는 것이 인터페이스
*/

class SoundPlayer{
  void play(){
    System.out.println("play wav");
  }
}
public class Client {
  public static void main(String[] args) {
    SoundPlayer sp = new SoundPlayer();
    sp.play();
  }
}
/*
이와 같은 형식에서 SoundPlayer가 다른 포맷의 파일을 재생하도록 요구사항이 생긴다면?
play() 메소드를 수정하는 것은 OCP 원칙에 위배되는 것이다.
이때 인터페이스를 활용한다.
*/

interface playAlgorithm{
  public void play();
}
class Wav implements playAlgorithm{
  @override
  public void play(){
    System.out.println("Play Wav");
  }
}
class Mp3 implements playAlgorithm{
  @override
  public void play(){
  System.out.println("Play Mp3");
  }
}

class SoundPlayer{
  private playAlgorithm file;

  public void setFile(playAlgorithm file){
    this.file = file;
  }
  public void play(){
    file.play();
  }
}
public class Client {
  public static void main(String[] args) {
    SoundPlayer sp = new SoundPlayer();
    sp.setFile(new Wav());
    sp.setFile(new Mp3());
    sp.play();
  }
}
// 이를 Strategy Pattern 이라고 하기도 함

/*
Liskov Substitution Principle(리스코프 치환 원칙)
- 자식 클래스는 부모 클래스의 행위를 수행할 수 있어야 함
- 부모 클래스와 자식 클래스 일관성 강조
- 부모 클래스 객체 대신 자식 클래스 객체를 사용해도 문제가 없어야 함
- IS-A 관계의 성립
*/

/*
Dependency Inversion Principle(의존 역전 원칙)
- 의존 관계를 맺을 때, 변화하기 쉬운 것 보다는 변화하기 어려운 것에 의존해야함
- 변화하기 쉬운 것이란? 구체화된 클래스
- 변화하기 어려운 것이란? 추상클래스 또는 인터페이스
-> 즉 구체화된 클래스보다는 추상클래스 또는 인터페이스와 관계를 맺는 것

OCP에서 다뤘던 부분에서, setFile을 이용해서 file 멤버 변수에 주입한다.
이것이 바로 의존성 주입의 예이다.
- 새로운 오디오 파일 포맷이 필요하다면, 새로운 클래스를 만들고 play 인터페이스를 상속받아,
setFile 메소드를 이용해서 file 멤버 변수에 주입
*/

/*
Interface Segregation Principle(인터페이스 분리 원칙)
- 하나의 일반적인 인터페이스보다는, 여러 개의 구체적인 인터페이스가 낫다.
- 즉 자신이 사용하지 않는 기능을 담은 인터페이스에는 영향을 받지 않아야 함
*/

