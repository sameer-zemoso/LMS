package DS;

public class MergeSortAlgo {
    public static void mergesort(int a[], int low, int high) {
        if(low<high) {
            int mid=(low+high)/2;
            mergesort(a,low,mid);
            mergesort(a,mid+1,high);
            merge(a,low,mid,high);
        }
    }
    public static void merge(int a[],int low,int mid,int high) {
        int p1=low;
        int p2=mid+1;
        int temp[]=new int[high-low+1];
        int k=0;
        while(p1<=mid && p2<=high) {
            if(a[p1]<a[p2])
                temp[k++]=a[p1++];
            else
                temp[k++]=a[p2++];
        }
        while(p1<=mid)
            temp[k++]=a[p1++];
        while(p2<=high)
            temp[k++]=a[p2++];
        for(int i=low;i<=high;i++) {
            a[i]=temp[i-low];
            System.out.print(a[i]+" ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        int ar[] = {2,3,4,-1,10,5,20,-120,45,1,0};
        mergesort(ar,0,ar.length-1);
    }
}
