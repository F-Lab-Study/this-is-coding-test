# [곱하기 혹은 더하기](https://github.com/Java-Algorithm-Study-Group/this-is-coding-test/blob/main/seungjun/src/greedy/Daily2.java)

## 문제

0-9로 이루어진 문자열 S가 주어졌을 때, 연산자위 우선순위와 상관없이 왼쪽부터 오른쪽 순서대로 '+' 혹은 '*'을 넣어 만들어질 수 있는 가장 큰 수를 구하시오.
또한 만들어질 수 있는 가장 큰 수는 항상 20억 이하의 정수가 되도록 입력이 주어집니다.

### Input

* 첫째 줄에 여러 개의 숫자로 구성된 하나의 문자열 S가 주어진다.(1 <= S의 길이 <= 20)

```
02984
```

```
567
```

### Output

* 첬째 줄에 만들어질 수 있는 가장 큰 수를 출력한다.

```
576
```

```
210
```

## 접근

'*'의 횟수 제한이 없으므로 현재 숫자가 0 또는 1이 아니라면 모든 연산을 *으로 처리한다.

```
result = 0
for (i = 0; i < S; i++)
    num = int(S.charAt(i)))
    if (result == 0 || num == 0 || num == 1)
        result += num
    else
        result *= num
```

## 시간 복잡도

O(n)