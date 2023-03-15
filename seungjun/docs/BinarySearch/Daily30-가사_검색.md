# 가사 검색

## [문제](https://school.programmers.co.kr/learn/courses/30/lessons/60060)

링크로 대체

* 풀이 시간 : 1시간

## 접근

queries의 패턴들은 '?'가 연속되게 나온다는 특징을 가지고 있다.<br>
즉, '?'가 없는 문자의 시작과 끝의 위치를 알아내서, words와 비교해 동일한 단어의 개수를 파악할 수 있다는 것이다.


'?'가 없는 시작과 끝 위치를 알아내기 위해서는 upperBound와 lowerBound를 구현해야 한다.

```
function upperBound(query):
    f = 0
    r = query.length() - 1
    
    while(f < r):
        m = (f + r) / 2
        if (query[m] == '?'):
            f = m + 1
        el
            r = m
            
    return f
```

```
function lowerBound(query):
    f = 0
    r = query.length() - 1
    
    while(f < r):
        m = (f + r) / 2
        if (query[m] != '?'):
            f = m + 1
        el
            r = m
            
    return f
```

마지막으로 단어를 비교할 때 다음과 같은 조건을 충족하는지 확인한다.

1. 길이가 동일한 단어
2. 검색할 패턴의 위치와 값이 동일한 단어

### 풀이 이슈

이번 풀이는 매칭되는 단어의 개수를 찾는다는 목적에는 맞았으나, 시간 복잡도가 틀렸다.<br>
내 풀이의 시간 복잡도는 O(N * M)으로 시간 제한 1초를 충족하지 못한다.

이 문제는 `O(logN)`으로 풀이가 가능하다.<br>
포인트는 '특정 패턴이 존재하는 문자열을 매칭해서 찾는다'가 아니라 `특정 패턴을 가진 문자열 범위 안에 속하는 단어들의 개수를 찾는다`로 접근해야 한다.

문자열 범위 탐색을 하기 위해서는 추상적으로 제시된 단어를 구체화 할 필요가 있다.<br>
예를 들어 `fro??`는 `froaa ~ frozz까지의 범위`를 가진다고 볼 수 있다.<br>
하지만 ??odo의 경우에는 범위 탐색이 불가하기 때문에 reverse로 뒤집어줄 필요가 있다.<br>
결과적으로 `odo??`가 되고, `odoaa ~ odozz`까지의 범위 탐색을 할 수 있게 된다.<br>

이렇게 생성된 범위를 가지고 탐색을 진행하기 위해서는 탐색 대상 단어들과 reverse된 탐색 대상 단어들 2가지로 단어를 가져가야 한다.<br>
또한 길이가 동일한 단어들만 비교해야 하므로 HashMap을 통해 길이별로 단어를 담아둘 필요가 있다.

범위 탐색은 aa로 시작하거나 큰 첫번째 문자, zz보다 큰 첫번째 문자 2가지로 정의될 수 있다.<br>
즉, lowerBound, upperBound를 구현해야 하며, 이 범위 안에 존재하는 단어의 갯수를 구하면 된다.

> [오답 코드](https://github.com/Java-Algorithm-Study-Group/this-is-coding-test/blob/main/seungjun/src/binary_search/Daily30.java)<br>
> [정답 코드](https://github.com/Java-Algorithm-Study-Group/this-is-coding-test/blob/main/seungjun/src/binary_search/Daily30Answer.java)