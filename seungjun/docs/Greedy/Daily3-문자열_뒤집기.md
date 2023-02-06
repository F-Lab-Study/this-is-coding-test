# [문자열 뒤집기]()

## 문제

0과 1로 이루어진 문자열 S가 있을 때, 0 또는 1로만 이루어진 문자열로 변경하려고 한다.<br>
연속된 숫자들만 한번에 변경할 수 있다고 할 때, 모두 동일한 숫자로 바꿀 수 있는 최소 횟수를 구하라.


### Input

* 길이가 100만 이하이며, 0과 1로 주어진 문자열 S를 입력한다.

```
0001100
```

### Output

* 최소 횟수를 출력한다.

```
1
```

## 접근

숫자를 하나씩 체크하며 0 또는 1중 연속된 수를 가지고 있는 문자열이 작은 그룹의 수를 체크한다.

```
String input = "0001100";
char preNumber = input.charAt(0);
int groupZeroCount = 0;
int groupOneCount = 0;
for (int i = 1; i < input.length(); i++) {
    if (preNumber != input.charAt(i)) {
        if (preNumber == '0') {
            groupZeroCount++;
        } else {
            groupOneCount++;
        }
        
        preNumber = input.charAt(i);
    }
}

if (preNumber == '0') {
    groupZeroCount++;
} else {
    groupOneCount++;
}

int result = groupZeroCount >= groupOneCount ? groupZeroCount : groupOneCount;
```