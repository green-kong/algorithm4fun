# [알파벳](https://www.acmicpc.net/problem/1987)

평범한 dfs 문제여서,
별 생각 없이 풀었는데 시간초과 났다.

`visted` 를 map으로 만들까 하다가, 귀찮아서 그냥 List로 만들었었다.
```java
List<String> visited = new ArrayList<>();

if(visited.contains(alphabet)) {
        ...
        }
```

대충 이런 식인데,  
`contains`가 O(n) 이라 그런 듯 했다.

음 map으로 바꿔야 되나.. 싶었는데,  
초기값을 잡거나, null 체크를 해줘야되는게 귀찮아서 생각해보다가  
알파벳 어차피 26글자니까 길이 26짜리 불리언 배열만들어서 쓰면 될 듯.

```java
static boolean[] visited = new boolean[26];

if (visited[idx]) {
        ...
}
```

이러면 O(1)이니까 되려나 싶었는데,  
다행히 되더라.