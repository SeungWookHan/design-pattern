// 해당 코드는 Run하기 위해 작성한 코드가 아닌 공부용으로 작성한 것임을 알립니다.

/*
State Pattern(스테이트 패턴)이란, 일련의 규칙에 따라 객체의 상태(State)를 변화시켜, 객체가 할 수 있는 행위를 바꾸는 패턴.
- State 패턴의 핵심은 상태를 인터페이스로 분리하는 것
*/

//예시) 알람시계

public interface State { // 상태 정의
  public void normal(Clock clock);
  public void alarm(Clock clock);
}

// Clock의 상태에 따라 호출될 메소드 정의
public class Clock {
  private State state; // 상태 저장

  public Clock(){
    state = new NormalState(); // 초기 상태 지정
  }

  public void setState(State state) {
    this.state = state;
  }

  public void normal() {
    state.normal(this);
  }
  public void alarm() {
    state.alarm(this);
  }
}

// 각각의 상태는 State 인터페이스를 상속받아 구현
class NormalState implements State {
  Clock clock;

  NormalState(){
    System.out.println("Normal 상태");
  }

  @override
  public void normal(Clock clock){
    System.out.println("normal normal 메소드 호출");
  }

  @override
  public void alarm(Clock clock){
    System.out.println("normal alarm 메소드 호출");
    System.out.println("알람을 울립니다.");
    clock.setState(new AlarmState());
  }
}

// Alarm State, 알람을 울린 후 다시 Normal State로 변경
class AlarmState implements State {
  int min;
  final int ALARM_TIME = 5;

  public AlarmState() {
    System.out.println("Alarm 상태");
    min = 0;
  }

  @override
  public void normal(Clock clock) {
    // 일정 시간 지난 후 다시 normal 상태로
    while(min <= ALARM_TIME) {
      System.out.println("min: " + min);
      min++;
    }
    clock.setState(new NormalState());
  }

  @override
  public void alarm(Clock clock){
  }
}

public class main {
  public static void main(String[] args) {
    Clock myClock = new Clock();
    myClock.normal(); // normal 상태에서 normal 호출
    myClock.alarm(); // normal 상태에서 alram 호출, alarm 작동

    myClock.normal(); // alarm 상태에서 normal 호출
  }
}