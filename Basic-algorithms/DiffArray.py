from array import array
import time
from bisect import bisect



# Input - array a , integer k 
# Output - Number of tuples of elements meet the requirement

'''
제 프로그래밍을 확인하시려면 python3 로 실행시키시면 됩니다. 그 후에 array 를 입력하시고 다음 줄에 k 를 입력하시면 됩니다.

이 문제는 두 가지 방법으로 접근 하였습니다. 그리고 array의 모든 인풋이 정수(int) 라고 가정을 하였으며, 두번째 메쏘드는 array의 정수중에 중복되는 정수는 없다는 가정을 하였습니다.
array 인풋은 스페이스로 띄어서 입력하셔야 합니다.  eg) 1 2 3 4 5

첫번째 방법은 for loop를 중복으로 사용하여, 주어진 array에 모든 원소를 비교하여 그 차이가 k 인지를 확인하는 방법입니다. 
이 방법은 array의 크기가 n 이라하면 for loop 이 두개 이기 때문에 O(n^2) 의 시간복잡도를 가집니다.

두 번째 방법은 주어진 array를 set 에 넣은 후에, array를 for loop 을 한번 돌리면서, array[i] - k 를 만족하는 원소가 set에 있는지 확인하는 방법입니다.
이 방법은 시간복잡도가 set은 hash table 을 사용한 기능이기 때문에, array를 set에 넣는 것과 search 하는 것은 O(n) 과 O(1) (average case) 의 시간이 걸리고, for loop를 한번만 사용하므로
O(n) 의 시간복잡도를 가지게 됩니다.

하지만, input array 에 중복된 숫자가 있을 수 있다면, 두번 째 방법은 정확한 결과를 만들어 내지 않으므로 첫번째 방법을 사용해야 합니다.
중복된 숫자가 있을 시에, 첫번째 방법보다 더 나은 방법은 인풋된 array를 quick sort 혹은 merge sort 로 순서대로 정렬을 한 후에, binary tree를 이용한 방법 으로 
array[i] - k = array[j] 를 만족하는 값이 있는지 찾아보면 첫번째 메소드보다 효율적으로 값을 찾을 수 있습니다. 

'''

def inputStream():  # 인풋을 처리하는 함수입니다. 
    arrayInput = input("Please input an array ").split(' ') # 인풋의 각 숫자는 스페이스로 뛰어져서 한줄로 들어와야합니다. 예시 ) 1 2 3 4 5 or 343 412 112 212 ...  
    kInput = input("Please input 'k'") # k 는 정수라고 가정.k 가 소수일 수도 있는 경우엔 float()을 사용하면됩니다.
    return arrayInput,int(kInput) 

def outputDoubleFor(arr,k): 
    newList=[]   # List
    counter = 0 
    size = len(arr) # 인풋에 들어온 원소의 갯수
    for i in range (0,size):
        for j in range (i+1,size):
            a = int(arr[i])    # String 으로 들어온 인풋을 정수형으로 변환. 
            b = int(arr[j])
            if(abs(a-b)==k):   # 원소 두개의 차이가 k 인지를 확인. 
                counter = counter +1 
                newList.append((arr[i],arr[j]))  
            else:
                pass
    print("Double For loop 방법을 사용한 정답은 "+ str(counter) + " 입니다. ")
#    print(newList) 원소 두개의 차이가 k 인 원소의 쌍의 리스트.

    return counter


    
def outputSet(arr,k):
    newSet = set(arr)  #  해쉬 테이블 방식으로 인풋이 저장됨. Unorderd
    counter = 0 
    for i in range (0,len(arr)):
        a = int(arr[i])
        if(str(a-k) in newSet): 
            counter = counter+1
                    
    print("Set 방법을 사용한 접답 또한 "+ str(counter) + " 입니다. ")
    
    return counter
    

def outputSortAndSearch(arr,k):
    arr.sort()
    sortedArr = list(map(int, arr))
    print(sortedArr)
    ans = bisect(sortedArr,2)
    print(ans)
    '''
    for i in range (0,len(arr)):
        a = int(sortedArr[i])
        ans = bisect(sortedArr-a,k)
    
    print(ans)
    
    
    
    for( i = 0;i < arr.length - 1; i++)
    {
       x = arr[i];
       bool found = binarySearch(sortedArr, T-x);//Search for T-x in sorted Arrary
       if(found)
        print "pair", x, T-x;
    }
    '''
           
        
    
func = inputStream()
#outputDoubleFor(*func) # For loop 을 중복으로 사용한 메쏘드. O(N^2) 만큼의 시간복잡도가 걸립니다. 
#outputSet(*func) #  Set 을 이용한 메쏘드. O(N) 만큼의 시간복잡도가 걸립니다. (어레이에 중복된 값이 존재하면 안됨) 
outputSortAndSearch(*func) # 정렬을 한 후에, binary search 로 

''' # 두가지 메쏘드 시간소요를 비교할 수 있는 코드입니다.
start = time.time()
outputDoubleFor(*func)
done = time.time()
elapsed = (done - start) * 10000
print("double for time taken "+str(elapsed))

start1 = time.time()
outputSet(*func)
done1 = time.time()
elapsed = (done1 - start1) * 10000
print("set time taken "+str(elapsed))
'''


    