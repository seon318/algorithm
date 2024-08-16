import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] heap;
	static int heapSize;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		int n;

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			heap = new int[n + 1];
			heapSize = 0;

			sb.append('#').append(tc).append(' ');

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				if (st.nextToken().equals("1")) {
					heappush(Integer.parseInt(st.nextToken()));
				} else
					heappop();
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}

	//위치 바꾸기
	static void swap(int i, int j) {
		int tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;
	}

	//삽입
	static void heappush(int x) {
		//맨 뒤 인덱스를 x로
		heap[++heapSize] = x;

		//해당 인덱스 = 자식, * 2 = 부모
		int p = heapSize / 2;
		int ch = heapSize;

		//자식이 루트 노드인 1보다 크고 자식이 부모보다 크다면
		while (ch > 1 && heap[p] < heap[ch]) {
			swap(p, ch); //위치 바꾸기
			ch = p; //자식이 부모가 됨
			p = ch / 2; //부모는 자식이 됨
		}

	}

	//삭제
	static void heappop() {
		//만약 아무 원소가 없다면 -1 출력
		if (heapSize == 0) {
			sb.append(-1).append(' ');
			return;
		}

		int x = heap[1]; //x에 최댓값 저장
		heap[1] = heap[heapSize]; //루트 노드에 마지막 값 가져오기
		heap[heapSize--] = 0; //마지막 노드는 0으로 초기화

		//루트 노드, 자식 노드
		int p = 1;
		int ch = p * 2;

		//자식이 사이즈보다 작거나 같은 동안 (만약 클 경우 자식이 없음)
		while (ch <= heapSize) {
			//왼쪽 자식과 오른쪽 자식 비교해서 오른쪽이 더 크면 그 인덱스로 변경
			if (ch + 1 <= heapSize && heap[ch] < heap[ch + 1]) {
				ch++;
			}
			
			//만약 부모가 자식보다 크다면 멈추기
			if (heap[p] >= heap[ch])
				break;
			
			//아니라면 위치 바꾸고 인덱스 갱신
			swap(p, ch);
			p = ch;
			ch = p * 2;
		}

		sb.append(x).append(' ');
	}

}