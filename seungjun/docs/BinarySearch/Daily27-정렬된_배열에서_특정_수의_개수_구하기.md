# 정렬된 배열에서 특정 수의 개수 구하기

## 문제

N개의 원소를 포함하고 있는 수열이 오름차순으로 정렬되어 있습니다. 이 때 이 수열에서 x가 등장하는 횟수를 계산하세요.<br>
예를 들어 수열 {1, 1, 2, 2, 2, 2, 3}에서 2의 등장 횟수는 4입니다.<br>
단, 이 문제는 시간 복잡도 `O(logN)`으로 알고리즘을 설계하지 않으면 '시간 초과' 판정을 받습니다.

### 제한 조건

* 풀이 시간 : 30분
* 시간 제한 : 1초
* 메모리 제한 : 128MB

### 입력 조건

* 첫째 줄에 N과 x가 정수 형태로 공백으로 구분되어 입력됩니다.<br>(1 <= N <= 1,000,000), (-10^9 <= x <= 10^9)
* 둘째 줄에 N개의 원소가 정수 형태로 공백으로 구분되어 입력됩니다.<br>(-10^9 <= 각 원소의 값 <= 10^9)

```
7 2
1 1 2 2 2 2 3
```
```
7 4
1 1 2 2 2 2 3
```

### 출력 조건

* 수열의 원소 중에서 값이 x인 원소의 개수를 출력합니다.
* 값이 x인 원소가 하나도 없다면 -1을 출력합니다.

```
4
```
```
-1
```

## 접근

정렬된 수에서 특정 원소를 추적하는 알고리즘은 이진 탐색이며, O(logN)의 시간 복잡도를 가진다.

특정 원소의 개수를 구하기 위해서는 `(첫번째 x의 위치)와 (마지막 x의 위치 + 1)의 차이`를 구하면 된다.<br>
각 위치를 구하기 위해서는 이진 탐색 기반의 lowerBound, upperBound 메서드를 활용해야 한다.

첫번째 x의 위치를 구하기 위해서는 `target보다 크거나 같은 첫번째 위치를 반환`하는 lowerBound 메서드를 구현한다.

```
int lowerBound(arr, target):
    front = 0
    rear = arr.length - 1
    
    while(front < rear):
        mid = (front + rear) / 2
    
        // target보다 크거나 같은 첫번째 위치를 반환
        if (arr[mid] >= target):
            rear = mid
        else:
            front = mid + 1
            
    return rear
```

만약 lowerBound() 위치의 값이 x와 동일하면 upperBound 메서드를 실행하고,<br> 
동일하지 않으면 x가 존재하지 않는 것이므로 -1을 출력해야 한다.

마지막 (x + 1)의 위치를 구하기 위해서는 `traget보다 큰 첫번째 위치를 반환`하는 upperBound의 메서드를 구현하면 된다.

```
int upperBound(arr, target):
    front = 0
    rear = arr.length - 1
    
    while(front < rear):
        mid = (front + rear) / 2
    
        // traget보다 큰 첫번째 위치를 반환
        if (arr[mid] > target):
            rear = mid
        else:
            front = mid + 1
            
    return rear
```

결과적으로 (upperBound() - lowerBound())가 x의 갯수가 된다.