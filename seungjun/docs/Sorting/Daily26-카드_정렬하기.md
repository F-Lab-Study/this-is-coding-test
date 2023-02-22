# 카드 정렬하기

## 문제

정렬된 두 묶음의 숫자 카드가 있을 때 각 묶음의 카드의 수를 A, B라 하면,<br>
보통 두 묶음을 합쳐서 하나로 만드는 데에는 A + B번의 비교를 해야 합니다.<br>
이를테면, 20장의 숫자 카드 묶음과 30장의 숫자 카드 묶음을 합치려면 50번의 비교가 필요합니다.

매우 많은 숫자 카드 묶음이 책상 위에 놓여 있습니다. 이들을 두 묶음씩 골라 서로 합쳐나간다면,<br>
고르는 순서에 따라 비교 횟수가 매우 달라집니다.<br>
예를 들어 10장, 20장, 40장의 묶음이 있다면 10장과 20장을 합친뒤, 합친 30장 묶음과 40장을 합친다면<br>
(10 + 20) + (30 + 40) = 100번의 비교가 필요합니다. 그러나 10장과 40장을 합친 뒤, 합친 50장 묶음과<br>
20장을 합친다면 (10 + 40) + (50 + 20) = 120번의 비교가 필요하므로 덜 효율적인 방법입니다.

N개의 숫자 카드 묶음의 각각의 크기가 주어질 때, 최소한 몇 번의 비교가 필요한지를 구하는 프로그램을 작성하세요.

### 제한 조건

* 풀이 시간 : 50분
* 시간 제한 : 2초
* 메모리 제한 : 128MB

### 입력 조건

* 첫째 줄에 N(1 <= N <= 100,000)이 주어집니다.
* N개의 줄에 걸쳐서 숫자 카드 묶음의 각각의 크기가 주어집니다.

```
3
10
20
40
```

### 출력 조건

* 첫째 줄에 최소 비교 횟수를 출력합니다.(21억 이하)

```
100
```

## 접근

이 문제는 아래와 같은 과정으로 연산이 반복된다.<br>
sum1 = x + y<br>
sum2 = sum1 + (sum1 + z)<br>
sum3 = sum2 + (sum2 + k)

이 방식에서 최소의 결과값을 얻으려면 숫자합이 최소가 되도록 유지하는 것이 포인트다.<br>
그러므로 입력된 카드 묶음을 오름차순으로 정렬한 뒤, 덧셈을 해나가면 된다.

1. 입력된 카드 묶음을 List에 담아 정렬한다.
2. List의 0, 1 인덱스의 값을 꺼내 sum1을 구하여 preSum에 저장한다.
3. preSum의 값을 SumList에 저장한다.
4. List의 2번 인덱스부터 값을 가져와 `preSum + preSum + List[i]` 연산 결과를 preSum에 저장한다.
5. preSum의 값을 SumList에 저장한다.
6. SumList의 값을 모두 더한 값을 출력한다.

### 풀이 이슈

이 문제는 Collection.sort로 접근해도 O(NlogN)이기 때문에 풀이가 가능하다.<br> 
그런데 풀이에 실패했다는 것은 문제에서 요구하는 결과값을 정확히 파악하지 못했다는 것이다.<br>
문제를 풀 때 조금더 신중하게 읽고 요구사항이 무엇인지 정확하게 파악할 필요가 있다.

또한 이 문제의 해설은 PriorityQueue로 풀이하고 있다. 이를 통해 좀 더 간단하게 풀이에 접근할 수 있다.<br>
앞으로는 요구사항에 적합한 콜렉션을 선택할 수 있도록 생각 범위를 넓혀보자.

* [힙 정렬](https://coding-factory.tistory.com/603)

> [내 풀이](https://github.com/Java-Algorithm-Study-Group/this-is-coding-test/blob/main/seungjun/src/sorting/daily26/Daily26.java)<br>
> [List로 풀이](https://github.com/Java-Algorithm-Study-Group/this-is-coding-test/blob/main/seungjun/src/sorting/daily26/Daily26AnswerList.java)<br>
> [PriorityQueue로 풀이](https://github.com/Java-Algorithm-Study-Group/this-is-coding-test/blob/main/seungjun/src/sorting/daily26/Daily26AnswerQueue.java)