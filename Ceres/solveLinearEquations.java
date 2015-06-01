public class solveLinearEquations {

public static double determinant(double A[][]){
		double sum=0;
	if (A.length==1){
		return A[0][0];
	}
	if (A.length==2){
		return A[0][0]*A[1][1]-A[0][1]*A[1][0];
	}
		for (int k=0;k<A.length;k++){
		double[][] Amini=new double[A.length-1][A.length-1];
			for(int i=1;i<A.length;i++){
				for(int j=0;j<A.length;j++){
					if(j<k){
				Amini[i-1][j]=A[i][j];
					}
					if(j>k){
				Amini[i-1][j-1]=A[i][j];
					}
				}
		sum=sum+Math.pow(-1,1+k+1)*A[0][k]*determinant(Amini);
			}
		}
		if(sum==0){
			System.out.println("Determinant=0, solution incorrect");
		}
		return sum;
	}
public static double[][] RevMatrix(double A[][]){
	double det=determinant(A);
	double[][] adj = new double[A.length][A.length];
		for(int m=0; m<A.length;m++){
			for (int n=0;n<A.length;n++){
			double[][] Minor = new double[A.length-1][A.length-1];
			for(int i=0; i<A.length;i++){
				for (int j=0;j<A.length;j++){
					if (i<m&&j<n){
						Minor[i][j]=A[i][j];	
					}
					if(i>m&&j>n){
						Minor[i-1][j-1]=A[i][j];		
					}
					if (i>m&&j<n){
						Minor[i-1][j]=A[i][j];	
					}
					if(i<m&&j>n){
						Minor[i][j-1]=A[i][j];	
					}
				}
			}
			adj[m][n]=Math.pow(-1, m+n+2)*determinant(Minor);
		}
	}
		double[][] temp=transponMatrix(adj);
		double [][] Arev = new double[A.length][A.length];
		for(int i=0;i<A.length;i++){
			for (int j=0;j<A.length;j++){
				Arev[i][j]=temp[i][j]*(1/det);
			}
		}
	return Arev;
}
public static double[][] transponMatrix(double A[][]){
	double temp=0;
	for(int i=0; i<A.length;i++){
		for (int j=i;j<A.length;j++){
			if(i!=j){
temp=A[i][j];
A[i][j]=A[j][i];
A[j][i]=temp;
			}
		}
	}
	return A;
}
public static double[][] SolveLinEq(double A[][], double B[][]){
	double [][] X = new double[B.length][B[0].length];
		X=MultiplyMatrixes(RevMatrix(A),B);
	return X;
}
public static double[][] MultiplyMatrixes(double A[][], double B[][]){
	double [][] C= new double[A.length][B[0].length];
	if(A[0].length==B.length){
	for (int i=0;i<A.length;i++){
		for (int j=0;j<B[0].length;j++){
			for (int n=0;n<B.length;n++){
			C[i][j]=C[i][j]+A[i][n]*B[n][j];
				}
			}
		}
	}
	return C;
}
public static void printMatrix(double A[][]){
	for (int i=0;i<A.length;i++){
		for (int j=0;j<A[0].length;j++){
	System.out.print("Matrix"+i+j+"="+A[i][j]+"  ");
			}
		System.out.print("\n");
		}
	System.out.print("\n");
	}
}