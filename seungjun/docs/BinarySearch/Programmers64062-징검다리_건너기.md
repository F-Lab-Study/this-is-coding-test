# 징검다리 건너기

## [문제](https://school.programmers.co.kr/learn/courses/30/lessons/64062)

링크로 대체

* 풀이 시간 : 50분

## 접근

문제를 풀기 위한 조건은 `값이 0인 디딤돌이 연속해서 K번 나오면 종료`다.<br>
그리고 찾아야 하는 것은 `0이 연속되서 나오는 첫번째 지점과 마지막 지점의 차이가 K보다 큰 경우`다.<br>
첫번째 지점과 마지막 지점을 알아야 하므로 lowerBound와 upperBound를 사용해야 한다.

* 디딤돌의 값이 가장 작은 인원 수는 무조건 건널 수 있다.
* 디딤돌의 값을 중복 제거 후 정렬한다.

1. 디딤돌을 HashSet에 넣어 중복을 제거 후 PriorityQueue에 넣어 정렬한다.
2. Queue에서 값을 꺼내서 각 stone의 값에서 뺀다. 만약 0보다 작아지면 0을 저장한다.
3. lowerBound를 통해 stones에서 0이 시작되는 첫번째 지점을 찾는다.
4. upperBound를 통해 stones에서 0으로 끝나는 마지막 지점을 찾는다.
5. upperBound - lowerBound 값이 K보다 크거나 같을 때까지 반환한다.

### 풀이 이슈

이 문제의 경우 접근 자체는 맞았으나 탐색 기준을 잘못 잡아서 완전히 다른 결과가 나오게 됐다.

`디딤돌의 값이 가장 작은 인원 수는 무조건 건널 수 있다`라는 것을 떠올렸을 때,<br> 
`디딤돌의 값이 가장 큰 수가 최대 이동 가능한 인원의 수`라는 것도 같이 알아냈어야 했다.<br>
결국 디딤돌의 값이 건널 수 있는 인원수를 알려주는 기준이 되는 것이다.

결국 탐색의 대상은 0의 시작/종료 지점이 아니라, `디딤돌의 값을 대입했을 때, 0이 연속해서 K번 발생하는 첫번째 지점`이 된다.<br>
그리고 첫번째 지점을 찾아야 하기 때문에 lowerBound를 사용해야 한다는 것을 알 수 있다.

lowerBound에서 front, rear 조건은 다음과 같다.

1. mid에 해당하는 값을 인덱스로 정렬된 디딤돌에서 값을 가져온다.
2. stones 값들을 하나씩 가져오면서 1의 값에서 stone 값을 빼면서 0보다 작으면 카운트하고, 크면 카운터를 초기화 한다.
3. count가 K보다 크거나 같으면 건널 수 있는 최대 인원 또는 인원 초과를 의미한다.<br>이 말은 해당 값 넘어가는 값들은 무의미하다는 뜻으로 rear에 mid를 저장한다.
4. count가 K보다 작으면 건널 수 있는 인원이 더 존재한다는 것을 의미한다.<br>이 말은 해당 값 미만의 값들은 무의미하다는 뜻으로 front에 (mid + 1)을 저장한다.
5. front < rear 조건을 충족하는 동안 반복한다.

루프가 종료된 후 rear의 값을 인덱스로 하는 stones 값이 건널 수 있는 최대 인원의 수가 된다.

<br>

> [오답 코드](https://github.com/Java-Algorithm-Study-Group/this-is-coding-test/blob/main/seungjun/src/binary_search/Programmers64062.java)<br>
> [정답 코드](https://github.com/Java-Algorithm-Study-Group/this-is-coding-test/blob/main/seungjun/src/binary_search/Programmers64062Answer.java)