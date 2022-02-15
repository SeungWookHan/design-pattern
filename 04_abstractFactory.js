// 해당 코드는 Run하기 위해 작성한 코드가 아닌 공부용으로 작성한 것임을 알립니다.

/*
추상 팩토리 = 추상 + 팩토리
추상화 = 구체화의 반대
즉, 실제 코드 부분이 작성되지 않고 어떻게 사용할지 명세(인터페이스)만 정의하는 것
*/

function takeOutCoffee(type) {
  let coffee;

  if(type == "latte") coffee = new Latte();
  else if(type == "espresso") coffee = new Espresso();
  else if(type == "cappuccino") coffee = new Cappuccino();

  coffee.prepare();
  coffee.make();
  coffee.boxing();

  return coffee;
}
/*
위 함수의 문제점은 무엇일까?
변화에 유연하지 않다.
새로운 종류의 커피가 추가 될때마다 if문의 분기를 추가해야 한다...

한두개의 커피가 추가되는 것은 어렵지 않겠지만, 커피의 종류가 얼마나 많이 추가될지 모른다.

그렇다면 어떻게 좋은 코드로 바꿀까?
바로 공통된 부분끼리 묶는 것이다.
여기에서는 type에 따라 커피 인스턴스를 생성해주는 부분을 묶어준다.
*/

function takeOutCoffee(type) {
  let coffee = coffeeFactory(type);

  coffee.prepare();
  coffee.make();
  coffee.boxing();

  return coffee;
}

// 특정 인스턴스를 만들어주는 클래스 또는 한수를 팩토리(Factory)라고 함
function coffeeFactory(type) {
  let coffee;
  if(type === 'latte') coffee = new Latte(); 
  else if(type === 'espresso') coffee = new Espresso(); 
  else if(type === 'cappuccino') coffee = new Cappuccino(); 
  else if(type === 'mocha') coffee = new Mocha(); 

  return coffee;
}
/*
이렇게 하면 새로운 커피가 추가되더라도 takeOutCoffee 함수를 고칠 필요가 없어진다.
메인 함수를 수정하는 것이 아니라, 수정될 부분을 분리하는 것 이라고 생각하면 된다.
*/

/*
여기까지는 팩토리이다.
그렇다면 추상 팩토리는 무엇을 의미하는가?
위에서 문제점은 물론 의존성은 분리되었지만, 새로운 종류의 커피가 추가될때마다
끊임없이 if문을 추가해야 한다는 것이다.

이를 해결하기 위해 추상화 개념을 추가한다.
추상화는 구체화의 반대말이다.
구체화 = 구현된 코드를 말한다.
위에서는 타입에 따라 coffee 변수에 인스턴스 할당하는 부분이 구체화된 부분이다.

그렇다면 인스턴스를 바같에서 만든다면 분기문을 제거할 수 있지 않을까?
이 생각에서 시작되는 것이 추상화이다.
*/

class CoffeeFactory {
  static createCoffee(factory) {
    return factory.createCoffee(); // 인스턴스를 만드는 행위를 추상화
  }
}

class LatteFactory {
  static createCoffee () {
    return new Latte();
  }
}

class EspressoFactory {
  static createCoffee () {
    return new Espresso();
  }
}

class CappuccinoFactory {
  static createCoffee () {
    return new Cappuccino();
  }
}

class MochaFactory {
  static createCoffee () {
    return new Mocha();
  }
}

// CoffeeFactory.createCoffee(LatteFactory);
// CoffeeFactory.createCoffee(EspressoFactory);
// CoffeeFactory.createCoffee(CappuccinoFactory);
// CoffeeFactory.createCoffee(MochaFactory);

function takeOutCoffee(factory) {
  let coffee = CoffeeFactory.createCoffee(factory);

  coffee.prepare();
  coffee.make();
  coffee.boxing();

  return coffee;
}
// 이와 같이 외부에서 의존성을 넘겨주는 방법을 의존성 주입(Dependency Injection)이라고 함
