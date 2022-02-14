// 해당 코드는 Run하기 위해 작성한 코드가 아닌 공부용으로 작성한 것임을 알립니다.

/*
싱글턴 패턴이란, 단 하나만의 인스턴스를 만들어 어디서든 접근할 수 있게 하는 패턴
*/
public class Singleton {
  private static Singleton sInstance = null;

  private Singleton(){

  }
  public static Singleton getInstance(){
    if(sInstance == null)
      sInstance = new Singleton();
  }
  return sInstance;
}
// Basic Singleton
/*
- 인스턴스를 저장할 변수를 전역으로 선언
- 생성자를 private으로 선언 -> 클래스 밖에서 객체 생성 불가
*/


/*
멀티스레디 환경이 될 경우, 인스턴스가 2개 이상 만들어질 수 있음.
그러면 이것을 어떻게 해결하나?
*/
public class Singleton {
  private static Singleton sInstance = null;

  private Singleton(){

  }
  public static synchronized Singleton getInstance(){
    if(sInstance == null) {
      try {
        Thread.sleep(10); // 10ms 대기
      } catch(InterruptedException e){
        e.printStackTrace();
      }
    }
    sInstance = new Singleton();
  }
  return sInstance;
}
// synchronized 사용, 쓰레드에서 인스턴스를 생성할때 동기화

public class Singleton {
  private static Singleton sInstance = new Singleton();

  private Singleton(){

  }
  public static Singleton getInstance(){
    if(sInstance == null) {
      try {
        Thread.sleep(10); // 10ms 대기
      } catch(InterruptedException e){
        e.printStackTrace();
      }
    }
    sInstance = new Singleton();
  }
  return sInstance;
}
// 정적 바인딩, 정적변수를 만들자마자 초기화