#include<stdio.h>
#include<math.h>
int main(){
	int n;scanf("%d",&n);
	float a[n];
	for(int i =0;i<n;i++){
		scanf("%f",&a[i]);
	}
	for(int i = n-1;i>=0;i--){
		printf("%.3f ",a[i]);
	}
}
