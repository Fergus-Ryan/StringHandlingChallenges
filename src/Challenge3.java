
public class Challenge3 {
	
	public static int solution(int[] A, int K, int L) {
        // write your code in Java SE 8
		
		if(K + L > A.length) {
			return -1;
		}
		
		int maxK = 0;
		int Kstart = 0;
		int Kend = 0;
		
		int maxL = 0;
		int Lstart = 0;
		int Lend = 0;
		
		if(K>L) {
			for(int i=0;i<A.length; i++) {
				int currK = 0;
				if(i+K-1 < A.length) {
					for(int j=i;j<i+K;j++) {
						currK += A[j];
					}
					if (currK > maxK) {
						maxK = currK;
						Kstart = i;
						Kend = i+K-1;
					}
				}
			}
			if(A.length-L > Kend) {
				for(int i=Kend+2; i<A.length; i++) {
					int currL = 0;
					if(i+L-1 < A.length) {
						for(int j=i;j<i+L;j++) {
							currL += A[j];
						}
						if (currL > maxL) {
							maxL = currL;
							Lstart = i;
							Lend = i+L-1;
						}
					}
				}
			}else {
				for(int i=0; i+L<Kstart; i++) {
					int currL = 0;
					for(int j=i;j<i+L;j++) {
						currL += A[j];
					}
					if (currL > maxL) {
						maxL = currL;
						Lstart = i;
						Lend = i+L-1;
					}
				}
			}
		}
		else {
			for(int i=0;i<A.length; i++) {
				int currL = 0;
				if(i+L-1 < A.length) {
					for(int j=i;j<i+L;j++) {
						currL += A[j];
					}
					if (currL > maxL) {
						maxL = currL;
						Lstart = i;
						Lend = i+L-1;
					}
				}
			}
			if(A.length-K > Lend) {
				for(int i=Lend+2; i<A.length; i++) {
					int currK = 0;
					if(i+K-1 < A.length) {
						for(int j=i;j<i+K;j++) {
							currK += A[j];
						}
						if (currK > maxK) {
							maxK = currK;
							Kstart = i;
							Kend = i+L-1;
						}
					}
				}
			}else {
				for(int i=0; i+K<Lstart; i++) {
					int currK = 0;
					for(int j=i;j<i+K;j++) {
						currK += A[j];
					}
					if (currK > maxK) {
						maxK = currK;
						Kstart = i;
						Kend = i+K-1;
					}
				}
			}
		}
		System.out.println(Kstart);
		System.out.println(Kend);
		System.out.println(Lstart);
		System.out.println(Lend);
		System.out.println(maxK);
		System.out.println(maxL);
		return maxK+maxL;
    }
	
	public static void main(String[] args) {
		int[] a = {1, 5, 9, 3, 2, 2, 5, 7, 8, 9};
		System.out.println(solution(a, 2, 4));
	}
}
