# [스택 수열](https://www.acmicpc.net/problem/1874)

로직 짜는것 보다 문제 해석이 더 어려웠음.  

예제 1번을 보면,  
**4 3 6 8 7 5 2 1** 이라는 수열을 만들고 싶어한다.  

스택에다가 1부터 오름차순으로 푸시를 한다.  

첫번째 값이 4니까,  
1부터 4번 푸시를 해준다.(++++) [1, 2, 3, 4]   
그리고 pop을 하면 첫번째 자리인 4는 만들어 졌다.(-) [1, 2, 3]  

다음음 3이니까, 현재 스택의 peek인 3을 pop해주면 된다. (-) [1, 2]

다음은 6인데, 마지막에 푸시한 값은 4였으니까 이젠 5부터 6까지 푸시해준다.(++) [1, 2, 5, 6]
그리고 pop을 해서 세번째자리 까지 만들었다.(-) [1, 2, 5]

다음 7부터 8까지 두번 푸시한다(++) [1, 2, 5, 7, 8]
그리고 pop(-) [1, 2, 5, 7]

이 다음 부턴 전부 pop만 해주면, (----)
4 3 6 8 7 5 2 1 수열이 완성된다.

이렇게 수열이 완성되는 경우는  +-를 출력해주면되고,  
수열이 완성되지 않는 경우는 NO를 출력해주면 된다.




