import java.util.HashMap;
import java.util.Scanner;

public class Main {

	// 8방향: 좌상, 상, 우상, 우, 우하, 하, 좌하, 좌
	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static int N, M, K;
	static char[][] word;
	static HashMap<String, Integer> count; // (단어, 등장 횟수) 저장  

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 격자 크기 N, M / 신이 좋아하는 문자열 개수 K
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		sc.nextLine(); // 개행 제거

		// 격자 
		word = new char[N][M];
		for (int i = 0; i < N; i++) {
			word[i] = sc.nextLine().toCharArray();
		}

		// 찾을 문자열 
		String[] words = new String[K];
		for (int i = 0; i < K; i++) {
			words[i] = sc.nextLine();
		}

		count = new HashMap<>();

		// 각 셀에서 단어 탐색 시작
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (String w : words) { // 각 단어에 대해 탐색
					searchWord(i, j, w); // 현재 위치에서 단어 찾기
				}
			}
		}

		// 결과 출력
		for (String w : words) {
			System.out.println(count.getOrDefault(w, 0));
		}
		
	} // main 

	// DFS | 시작 위치 x, y & 찾아야 하는 단어 
	public static void searchWord(int x, int y, String w) {
		int wordLen = w.length(); // 단어의 길이

		// 8방향 탐색
		for (int dir = 0; dir < 8; dir++) {
			int nx = x; 
			int ny = y; 
			boolean found = true; // 단어 발견 여부 체크 

			// 단어의 모든 문자에 대해 탐색
			for (int k = 0; k < wordLen; k++) {
				// 현재 위치의 문자와 목표 단어의 문자 비교
				if (word[nx][ny] != w.charAt(k)) {
					found = false; // 단어를 발견하지 못함
					break;
				}
				// 다음 좌표 계산 (모듈로 연산으로 경계 처리)
				nx = (nx + dx[dir] + N) % N;
				ny = (ny + dy[dir] + M) % M;
			}

			// 단어를 찾았으면 카운트 증가
			if (found) {
				count.put(w, count.getOrDefault(w, 0) + 1);
			}
		}
		
	} // searchWord 
} // class
