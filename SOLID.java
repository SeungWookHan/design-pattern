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