import math
import functools, operator
import time 

'''
제 프로그램을 확인하시려면 이 파일을 실행시키면 됩니다. 
'''

n=5  # n! 값을 계산함. 

def factorialRecursive(number):
    if number==0:
        return 1
    else:
        return number*factorialRecursive(number-1)

def factorialIterative(number):
    sum = 1
    for i in range(1,number+1):
        sum = sum * i
    return sum


# 매번 10을 곱할때 마다, 뒤에 0이 하나 붙은 다는 점을 생각하여 optimize 를 시켜보았습니다. 
# 10은 2*5 이며, 어떠한 팩토리얼을 계산하든간에, 2가 5보다 많이 반복되므로 
# 5가 나오면 5를 제외하고 계산을 하였습니다. 숫자가 많이 커진다고 하면, 이 방법의 효율성이
# 앞에 있는 두개의 방법보다 좋을 것이라고 생각합니다. 숫자가 조금만 커져도 오차가 생기는데
# 아직 원인은 발견하지 못했습니다.
def factorialOptimized(number):
    sum = 1
    fiveCounter = 0
    for i in range(1,number+1):
        if((i%5)==0):
            fiveCounter = fiveCounter + 1 
            sum = sum * (i/10) # 5가 등장하면, 10 을 나누어서 수를 작게 만든 후에 계산함.
        else:
            sum = sum * i
    
    numberOfFive = '0'*fiveCounter
    answer = str(int(sum))+numberOfFive
    return answer

# 이미 연산이 되어진 숫자는 tuple에 넣는 방법을 사용했습니다. 숫자가 커지면 커질 수록 연산을 하는것보다 
# 튜플에서 연산 결과를 찾아오는 것이 더 빨라질 수 있습니다.
memoization = {}
def factorialMemoization(k):
    if k < 2: return 1
    if not k in memoization:
        memoization[k] = k * factorialMemoization(k-1)
    return memoization[k]


print(str(n)+"! 의 연산 결과는 아래와 같습니다.")
print("for 루프를 사용 : "+str(factorialIterative(n))) # for loop 사용  
print("재귀호출을 사용 : "+str(factorialRecursive(n))) # 재귀
print("Memoization   : "+str(factorialMemoization(n))) 
print("5의 배수를 나누기: "+str(factorialOptimized(n)))
print("정답 : "+str(math.factorial(n)))  # 모듈 사용. n이 양의 정수가 아니면 ValueError  



'''
start = time.time()
factorialIterative(n) # while loop 사용  
end = time.time()
print((end - start)*10000)


start = time.time()
factorialRecursive(n) # 재귀
end = time.time()
print((end - start)*10000)


start = time.time()
factorialMemoization(n) 
end = time.time()
print((end - start)*10000)

start = time.time()
factorialOptimized(n)
end = time.time()
print((end - start)*10000)

start = time.time()
math.factorial(n)  # 모듈 사용. n이 양의 정수가 아니면 ValueError  
end = time.time()
print((end - start)*10000)
'''
