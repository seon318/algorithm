import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N]; // 주어진 수열
		int[] newArr = new int[N]; // 찾으려고자 하는 수열

		// 주어진 수열 저장
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// newArr 초기 값 : 첫 번째 수열의 값
		newArr[0] = arr[0];
		int idx = 1; // 수열의 길이

		// 증가하는 수열 중 가장 긴 수열 찾는 과정
		for (int i = 1; i < N; i++) { // 이미 첫 번째 값 넣었으니까 1부터
			// 남은 기존 수열의 첫번째 값이 찾고자 하는 수열의 마지막 값보다 큰지 체크
			// 크다면 고대로 추가
			if (arr[i] > newArr[idx - 1]) {
				idx++;
				newArr[idx - 1] = arr[i];
			}
			// 작다면 다음 과정을 진행
			else {
				// 여기서 이분탐색
				int left = 0;
				int right = idx;
				// arr[i] 보다 큰 값 중 가장 가까운 값 찾기
				while (left < right) {
					int mid = (left + right) / 2;
					if (newArr[mid] < arr[i]) {
						left = mid + 1;
					} else {
						right = mid;
					}
				}
				// 찾았다면 값 대치
				newArr[left] = arr[i];
			}
		}

		System.out.println(idx);
	} // main
} // class